package com.kn.service;

import com.kn.dao.EmployeeDao;
import com.kn.dao.EmployeeDaoImpl;
import com.kn.dao.MetaDataDao;
import com.kn.dao.MetaDataDaoImpl;
import com.kn.dto.EmployeeDto;
import com.kn.dto.MetaData;
import com.kn.entity.Employee;
import com.kn.exception.ServiceException;

/**
 * @author krishnanand
 *
 */
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao empDao = new EmployeeDaoImpl();
	private MetaDataDao metadao = new MetaDataDaoImpl();

	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}


	public void setMetadao(MetaDataDao metadao) {
		this.metadao = metadao;
	}


	@Override
	public EmployeeDto findEmployee(int mID) throws ServiceException {
		return empDao.findEmployee(mID);
	}


	@Override
	public MetaData getMetaData() throws ServiceException {
		return metadao.getData();
	}


	@Override
	public void saveEmployee(Employee employee) throws ServiceException {
		empDao.saveEmployee(employee);
	}

}
