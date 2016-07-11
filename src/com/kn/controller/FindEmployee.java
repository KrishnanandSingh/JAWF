package com.kn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kn.processor.RequestHandler;
import com.kn.processor.URLMapping;

/**
 * @author krishnanand
 *
 */
@URLMapping(urlPattern = "/findEmployee.do")
public class FindEmployee implements RequestHandler {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) {
		String mID = request.getParameter("mID");
		System.out.println("Finding employee for mID:"+mID);
	}

}
