package com.kn.dao;

import com.kn.dto.EmployeeDto;
import com.kn.entity.Employee;
import com.kn.exception.DaoException;

public interface EmployeeDao {

	EmployeeDto findEmployee(int mID) throws DaoException;

	void saveEmployee(Employee employee) throws DaoException;

}