package com.kn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kn.dto.EmployeeDto;
import com.kn.dto.Message;
import com.kn.dto.Message.TYPE;
import com.kn.entity.Competence;
import com.kn.entity.Employee;
import com.kn.entity.Subpractice;
import com.kn.entity.Vertical;
import com.kn.exception.ServiceException;
import com.kn.processor.RequestHandler;
import com.kn.processor.URLMapping;
import com.kn.service.EmployeeService;
import com.kn.service.EmployeeServiceImpl;

/**
 * @author krishnanand
 *
 */
@RequestHandler
public class EmployeeController {
	private EmployeeService empServ = new EmployeeServiceImpl();

	@URLMapping(urlPattern = "/findEmployee.do")
	public void findEmployee(HttpServletRequest request, HttpServletResponse response) {
		String mID = request.getParameter("mID");
		PrintWriter out = null;
		Gson gson = new Gson();
		try {
			out = response.getWriter();
			EmployeeDto employee = empServ.findEmployee(Integer.parseInt(mID));
			String emp = gson.toJson(employee);
			out = response.getWriter();
			out.append(emp);
		} catch (NumberFormatException e) {
			out.append(gson.toJson(new Message(TYPE.ERROR, "Invalid mid: " + mID)));
		} catch (ServiceException e) {
			out.append(gson.toJson(new Message(TYPE.ERROR, e.getMessage())));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}

	@URLMapping(urlPattern = "/saveEmployee.do")
	public void saveEmployee(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("name");
		String mID = request.getParameter("mID");
		String competencyID = request.getParameter("competency");
		String subpracticeID = request.getParameter("subpractice");
		String verticalID = request.getParameter("vertical");
		PrintWriter out = null;
		Gson gson = new Gson();
		try {
			out = response.getWriter();
			Competence competence = new Competence();
			Subpractice prac = new Subpractice();
			Vertical vertical = new Vertical();
			competence.setIdcompetence(Integer.parseInt(competencyID));
			prac.setIdsubpractice(Integer.parseInt(subpracticeID));
			vertical.setIdvertical(Integer.parseInt(verticalID));
			int mid = Integer.parseInt(mID);
			Employee employee = new Employee(mid, name, competence, prac, vertical);
			empServ.saveEmployee(employee);
			Message mesg = new Message(TYPE.MESSAGE, "Employee " + name + " added successfully");
			out.append(gson.toJson(mesg));
		} catch (NumberFormatException e) {
			out.append(gson.toJson(new Message(TYPE.ERROR, "Invalid data")));
		} catch (ServiceException e) {
			out.append(gson.toJson(new Message(TYPE.ERROR, e.getMessage())));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}

	}
	
	@URLMapping(urlPattern="/getAllEmployees.do")
	public void getAllEmployees(HttpServletRequest request, HttpServletResponse response){
		PrintWriter out = null;
		Gson gson = new Gson();
		try {
			out = response.getWriter();
			List<EmployeeDto> employees = empServ.findAllEmployees();
			String emp = gson.toJson(employees);
			out = response.getWriter();
			out.append(emp);
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
