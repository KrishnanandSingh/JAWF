package com.kn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kn.dto.Message;
import com.kn.dto.MetaData;
import com.kn.dto.Message.TYPE;
import com.kn.exception.DaoException;
import com.kn.exception.ServiceException;
import com.kn.processor.RequestHandler;
import com.kn.processor.URLMapping;
import com.kn.service.EmployeeService;
import com.kn.service.EmployeeServiceImpl;

@RequestHandler
public class FetchMeta {
	private EmployeeService empServ = new EmployeeServiceImpl();

	@URLMapping(urlPattern = "/metaData.do")
	public void process(HttpServletRequest request, HttpServletResponse response) throws DaoException {
		PrintWriter out = null;
		Gson gson = new Gson();
		try {
			out = response.getWriter();
			MetaData metadata = empServ.getMetaData();
			String md = gson.toJson(metadata);
			out.append(md);
			out.close();
		} catch (ServiceException e) {
			out.append(gson.toJson(new Message(TYPE.ERROR, e.getMessage())));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}

	}

}
