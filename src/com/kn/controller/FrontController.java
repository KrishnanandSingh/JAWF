package com.kn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kn.dto.Message;
import com.kn.dto.Message.TYPE;
import com.kn.processor.HandlerFactory;
import com.kn.processor.RequestHandler;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns = { "*.do" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		String[] packages = new String[] { "com.kn.controller" };
		HandlerFactory.initializeHandlers(getClass().getClassLoader(), packages);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();
		RequestHandler handler = HandlerFactory.getRequestHandler(url);
		if (handler != null) {
			handler.process(request, response);
		} else {
			Message errorMessage = new Message(404, TYPE.ERROR, "don't know what to do with: " + url);
			Gson gson = new Gson();
			response.getWriter().append(gson.toJson(errorMessage)).close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
