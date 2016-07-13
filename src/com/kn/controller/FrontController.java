package com.kn.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kn.dto.Message;
import com.kn.dto.Message.TYPE;
import com.kn.processor.Handler;
import com.kn.processor.HandlerFactory;

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
		Handler handler = HandlerFactory.getHandler(url);
		Message errorMessage = null;
		boolean hasError = false;
		if (handler != null) {
			try {
				handler.invokeMethod(request, response);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				hasError = true;
				errorMessage = new Message(501, TYPE.ERROR, "Server dancing for: " + url);
				e.printStackTrace();
			}
		} else {
			hasError = true;
			errorMessage = new Message(404, TYPE.ERROR, "don't know what to do with: " + url);
		}
		if (hasError) {
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
