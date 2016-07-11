package com.kn.processor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Factory class to find and map {@linkplain RequestHandler}s annotated with
 * {@linkplain URLMapping} </br>
 * Usage:</br>
 * String[] packages = new String[] { "com.kn.frontcontroller"};</br>
 * HandlerFactory.initializeHandlers(getClass().getClassLoader(), packages); </br>
 * 
 * @author krishnanand
 *
 */
public class HandlerFactory {

	private static Map<String, RequestHandler> handlers = new HashMap<>();

	public static RequestHandler getRequestHandler(String url) {
		return handlers.get(url);
	}

	/**
	 * Has to be called at init
	 * 
	 * @param classLoader
	 * @param packages
	 */
	public static void initializeHandlers(ClassLoader classLoader, String[] packages) {
		AnnotationProcessor ap = new AnnotationProcessor();
		Set<Class<?>> classes = ap.processAnnotations(URLMapping.class, packages, classLoader);
		System.out.println("Initializing handlers");
		if (classes.size() > 0) {
			StringBuilder mappings = new StringBuilder();
			for (Class<?> handler : classes) {
				URLMapping urlMapping = handler.getAnnotation(URLMapping.class);
				try {
					RequestHandler requestHandler = (RequestHandler) handler.newInstance();
					handlers.put(urlMapping.urlPattern(), requestHandler);
					mappings.append("[\"" + urlMapping.urlPattern() + "\",\"" + requestHandler.getClass() + "\"]");
					mappings.append(", ");
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Mappings found: " + mappings.substring(0, mappings.toString().length() - 2));
		} else {
			System.err.println("No mappings found");
		}
	}

}
