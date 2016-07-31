package com.kn.service;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kn.dao.EmployeeDao;
import com.kn.dao.MetaDataDao;
import com.kn.dto.EmployeeDto;
import com.kn.dto.MetaData;
import com.kn.entity.Employee;
import com.kn.exception.DaoException;
import com.kn.exception.ServiceException;

public class EmployeeServiceTest {
	private static EmployeeDao employeeDao;
	private static MetaDataDao metaDataDao;
	private static EmployeeService employeeService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		metaDataDao = new MetaDataDao() {
			
			@Override
			public MetaData getData() throws DaoException {
				return null;
			}
		};
		employeeDao = new EmployeeDao() {
			
			@Override
			public void saveEmployee(Employee employee) throws DaoException {
				
			}
			
			@Override
			public EmployeeDto findEmployee(int mID) throws DaoException {
				return null;
			}
		};
		employeeService = new EmployeeServiceImpl();
		((EmployeeServiceImpl)employeeService).setEmpDao(employeeDao);
		((EmployeeServiceImpl)employeeService).setMetadao(metaDataDao);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		employeeDao = null;
		metaDataDao = null;
	}

	@Test
	public final void testFindEmployee() throws ServiceException {
		fail("Not yet implemented");
		int mid = 1028099;
		EmployeeDto actual = employeeService.findEmployee(mid);
	}
	
	@Test(expected=ServiceException.class)
	public final void testFindEmployeeNe() throws ServiceException {
		int mid = 1028099;
		employeeService.findEmployee(mid);
	}

	@Test
	public final void testGetMetaData() {
		fail("Not yet implemented");
	}

	@Test
	public final void testSaveEmployee() {
		fail("Not yet implemented");
	}

}
