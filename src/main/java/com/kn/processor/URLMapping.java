package com.kn.processor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used by {@linkplain HandlerFactory} to get methods for request
 * mappings. With this mapping the HandlerFactory decides which request should
 * be forwarded to which method. <br>
 * Prerequisite: Only classes annotated with {@linkplain RequestHandler} will be
 * scanned for {@linkplain URLMapping}
 * 
 * @author krishnanand
 *
 */
@Target({ java.lang.annotation.ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface URLMapping {

	/**
	 * e.g. urlPattern="/performAction.do"<br>
	 * It says urlPattern but regex is not supported yet
	 */
	String urlPattern();

}
