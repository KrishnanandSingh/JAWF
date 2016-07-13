package com.kn.processor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Factory class to find and map {@linkplain Handler}s annotated with
 * {@linkplain URLMapping} </br>
 * Usage:</br>
 * String[] packages = new String[] { "com.kn.frontcontroller"};</br>
 * HandlerFactory.initializeHandlers(getClass().getClassLoader(),
 * packages); </br>
 * 
 * @author krishnanand
 *
 */
public class HandlerFactory {

	private static Map<String, Handler> requestMappings = new HashMap<>();

	public static Handler getHandler(String url) {
		return requestMappings.get(url);
	}

	/**
	 * Has to be called at init
	 * 
	 * @param classLoader
	 * @param packages
	 */
	public static void initializeHandlers(ClassLoader classLoader, String[] packages) {
		AnnotationProcessor ap = new AnnotationProcessor();
		Set<Class<?>> classes = ap.processAnnotations(RequestHandler.class, packages, classLoader);
		System.out.println("Initializing handlers");
		if (classes.size() > 0) {
			StringBuilder mappings = new StringBuilder();
			for (Class<?> clazz : classes) {
				try {
					System.out.println(clazz);

					Object classObj = clazz.newInstance();
					Method[] publicMethods = clazz.getMethods();
					for (Method method : publicMethods) {
						URLMapping urlMapping = method.getAnnotation(URLMapping.class);
						if (urlMapping != null) {
							Handler handler = new Handler(classObj, method);
							requestMappings.put(urlMapping.urlPattern(), handler);
							mappings.append("[\"" + urlMapping.urlPattern() + "\",\"" + clazz.getName() + "-"
									+ method.getName() + "()\"]");
							mappings.append(", ");
						}
					}
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if (mappings.length() > 2) {
				System.out.println("Mappings found: " + mappings.substring(0, mappings.toString().length() - 2));
			} else {
				System.err.println("No mappings found");
			}
		} else {
			System.err.println("No mappings found");
		}
	}

}
