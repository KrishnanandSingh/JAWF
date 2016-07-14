package com.kn.processor;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * @author krishnanand
 *
 */
public class AnnotationProcessor {

	/**
	 * @param annotation
	 * @param packages
	 * @return {@linkplain Set} of {@linkplain Class}es that are annotated with
	 *         annotation in the specified package. Set will be empty if none
	 *         found
	 */
	public Set<Class<?>> processAnnotations(Class<? extends Annotation> annotation, String[] packages) {
		Set<Class<?>> classes = getAllClasses(packages);
		Set<Class<?>> annotatedClasses = new HashSet<>();
		for (Class<?> clazz : classes) {
			Annotation declaredAnnotation = clazz.getAnnotation(annotation);
			if (declaredAnnotation != null) {
				annotatedClasses.add(clazz);
			}
		}
		return annotatedClasses;
	}

	/**
	 * @param annotation
	 * @param packages
	 * @param classLoader
	 * @return {@linkplain Set} of {@linkplain Class}es that are annotated with
	 *         annotation in the specified package. Set will be empty if none
	 *         found
	 */
	public Set<Class<?>> processAnnotations(Class<? extends Annotation> annotation, String[] packages,
			ClassLoader classLoader) {
		Set<Class<?>> classes = getAllClasses(packages, classLoader);
		Set<Class<?>> annotatedClasses = new HashSet<>();
		for (Class<?> clazz : classes) {
			Annotation declaredAnnotation = clazz.getAnnotation(annotation);
			if (declaredAnnotation != null) {
				annotatedClasses.add(clazz);
			}
		}
		return annotatedClasses;
	}

	public Set<Class<?>> getAllClasses(String[] packages, ClassLoader classLoader) {
		Set<Class<?>> classes = new HashSet<>();
		for (String pakage : packages) {
			classes.addAll(getAllClasses(pakage, classLoader));
		}
		return classes;
	}

	public Set<Class<?>> getAllClasses(String[] packages) {
		Set<Class<?>> classes = new HashSet<>();
		for (String pakage : packages) {
			classes.addAll(getAllClasses(pakage));
		}
		return classes;
	}

	/**
	 * @param scanPackage
	 * @return {@linkplain Set} of {@linkplain Class}es that are loaded from the
	 *         specified package. Set will be empty if none found
	 */
	public Set<Class<?>> getAllClasses(String scanPackage, ClassLoader classLoader) {
		String realPath = scanPackage.replace(".", "/");
		Set<Class<?>> classes = new HashSet<>();
		try {
			Enumeration<URL> urls = classLoader.getResources(realPath);
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				try {
					File directory = new File(url.toURI());
					if (directory.isDirectory()) {
						File[] files = directory.listFiles();
						for (File file : files) {
							String fileName = file.getName();
							if (fileName.endsWith(".class")) {
								String className = scanPackage + '.' + fileName.subSequence(0, fileName.length() - 6);
								try {
									classes.add(Class.forName(className));
								} catch (ClassNotFoundException e) {
									System.err.println("class: " + className + " could not be loaded");
								}
							}
						}
					}
				} catch (URISyntaxException e) {
					System.err.println("this is not supposed to happen");
					e.printStackTrace();
				}

			}
		} catch (IOException e) {
			System.err.println("could not get " + realPath + " as resource");
		}

		return classes;
	}

	public Set<Class<?>> getAllClasses(String scanPackage) {
		System.out.println("Using system classloader");
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		return getAllClasses(scanPackage, classLoader);
	}
}
