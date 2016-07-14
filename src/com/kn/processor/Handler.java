package com.kn.processor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author krishnanand
 *
 */
public class Handler {

	private Object handler;
	private Method method;

	public Handler() {
		super();
	}

	/**
	 * @param handler
	 * @param method
	 */
	public Handler(Object handler, Method method) {
		super();
		this.handler = handler;
		this.method = method;
	}

	public Object getHandler() {
		return handler;
	}

	public void setHandler(Object handler) {
		this.handler = handler;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public void invokeMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		method.invoke(handler, request, response);
	}
}
