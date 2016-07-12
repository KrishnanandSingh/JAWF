package com.kn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kn.dao.EmployeeDao;
import com.kn.dto.EmployeeDto;
import com.kn.processor.RequestHandler;
import com.kn.processor.URLMapping;

@URLMapping(urlPattern = "/saveEmployee.do")
public class SaveEmployee implements RequestHandler {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String mID = request.getParameter("mID");
		String competency = request.getParameter("competency");
		String subpractice = request.getParameter("subpractice");
		String vertical = request.getParameter("vertical");
		EmployeeDto employeeDto = new EmployeeDto(name, mID, competency, subpractice, vertical);
	
		EmployeeDao empdao=new EmployeeDao();
		empdao.saveEmployee(employeeDto);
		Gson gson = new Gson();
		gson.toJson(employeeDto, System.out);

	}

}
