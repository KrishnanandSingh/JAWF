package com.kn.processor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author krishnanand
 *
 */
public interface RequestHandler {

	void process(HttpServletRequest request, HttpServletResponse response);

}
