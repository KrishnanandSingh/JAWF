package com.kn.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kn.dao.EmployeeDao;
import com.kn.dto.EmployeeDto;
import com.kn.dto.Message;
import com.kn.dto.Message.TYPE;
import com.kn.processor.RequestHandler;
import com.kn.processor.URLMapping;

@RequestHandler
public class SaveEmployee {

	@URLMapping(urlPattern = "/saveEmployee.do")
	public void process(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String mID = request.getParameter("mID");
		String competency = request.getParameter("competency");
		String subpractice = request.getParameter("subpractice");
		String vertical = request.getParameter("vertical");
		EmployeeDto employeeDto = new EmployeeDto(name, mID, competency, subpractice, vertical);

		EmployeeDao empdao = new EmployeeDao();
		empdao.saveEmployee(employeeDto);
		Gson gson = new Gson();
		Message mesg = new Message(TYPE.MESSAGE, "Employee " + name + " added successfully");
		gson.toJson(employeeDto, System.out);
		try {
			response.getWriter().append(gson.toJson(mesg)).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
