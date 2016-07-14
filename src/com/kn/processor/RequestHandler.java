package com.kn.processor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation should be declared on every class that has methods annotated
 * with {@linkplain URLMapping}.<br>
 * Note that the annotated class will be singleton and not thread-safe.
 * Thread-safe implementation is left to the developer
 * 
 * @author krishnanand
 * 
 */
@Target(java.lang.annotation.ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestHandler {

}
