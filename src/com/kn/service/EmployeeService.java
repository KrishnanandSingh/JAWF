package com.kn.service;

import com.kn.dto.EmployeeDto;
import com.kn.dto.MetaData;
import com.kn.entity.Employee;
import com.kn.exception.ServiceException;

public interface EmployeeService {

	public EmployeeDto findEmployee(int mid) throws ServiceException;

	public void saveEmployee(Employee employee) throws ServiceException;

	public MetaData getMetaData() throws ServiceException;

}