package com.kn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kn.dao.EmployeeDao;
import com.kn.dto.EmployeeDto;
import com.kn.processor.RequestHandler;
import com.kn.processor.URLMapping;

/**
 * @author krishnanand
 *
 */
@RequestHandler
public class FindEmployee {

	@URLMapping(urlPattern = "/findEmployee.do")
	public void process(HttpServletRequest request, HttpServletResponse response) {
		String mID = request.getParameter("mID");
		System.out.println("Finding employee for mID:" + mID);
		EmployeeDao empdao = new EmployeeDao();
		EmployeeDto employee = empdao.findEmployee(mID);
		Gson gson = new Gson();
		String emp = gson.toJson(employee);
		try {
			PrintWriter out = response.getWriter();
			out.append(emp);
			out.close();
			System.out.println(emp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
