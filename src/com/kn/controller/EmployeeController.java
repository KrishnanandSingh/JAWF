package com.kn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kn.dao.EmployeeDao;
import com.kn.dto.EmployeeDto;
import com.kn.dto.Message;
import com.kn.dto.Message.TYPE;
import com.kn.processor.RequestHandler;
import com.kn.processor.URLMapping;

/**
 * @author krishnanand
 *
 */
@RequestHandler
public class EmployeeController {

	@URLMapping(urlPattern = "/findEmployee.do")
	public void findEmployee(HttpServletRequest request, HttpServletResponse response) {
		String mID = request.getParameter("mID");
		PrintWriter out = null;
		Gson gson = new Gson();
		try {
			int mid = Integer.parseInt(mID);
			EmployeeDao empdao = new EmployeeDao();
			EmployeeDto employee = empdao.findEmployee(mID);
			String emp = gson.toJson(employee);
			out = response.getWriter();
			out.append(emp);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			out.append(gson.toJson(new Message(TYPE.ERROR, "Invalid mid: " + mID)));
		}
	}

	@URLMapping(urlPattern = "/saveEmployee.do")
	public void saveEmployee(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String mID = request.getParameter("mID");
		String competency = request.getParameter("competency");
		String subpractice = request.getParameter("subpractice");
		String vertical = request.getParameter("vertical");
		// TODO check if valid
		PrintWriter out = null;
		Gson gson = new Gson();
		try {
			int mid = Integer.parseInt(mID);
			EmployeeDto employeeDto = new EmployeeDto(name, mID, competency, subpractice, vertical);
			EmployeeDao empdao = new EmployeeDao();
			empdao.saveEmployee(employeeDto);
			Message mesg = new Message(TYPE.MESSAGE, "Employee " + name + " added successfully");
			response.getWriter().append(gson.toJson(mesg)).close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			out.append(gson.toJson(new Message(TYPE.ERROR, "Invalid mid: " + mID)));
		}

	}

}
