package com.kn.service;

import java.util.List;

import com.kn.dao.EmployeeDao;
import com.kn.dao.EmployeeDaoImpl;
import com.kn.dao.MetaDataDao;
import com.kn.dao.MetaDataDaoImpl;
import com.kn.dto.EmployeeDto;
import com.kn.dto.MetaData;
import com.kn.entity.Competence;
import com.kn.entity.Employee;
import com.kn.entity.Subpractice;
import com.kn.entity.Vertical;
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
		EmployeeDto employeeDto = empDao.findEmployee(mID);
		if (employeeDto == null) {
			throw new ServiceException("No employee exists with id:" + mID);
		}
		return employeeDto;
	}

	@Override
	public MetaData getMetaData() throws ServiceException {
		MetaData metaData = metadao.getData();
		if (metaData == null || metaData.getCompetence().size() == 0 || metaData.getSubpractice().size() == 0
				|| metaData.getVertical().size() == 0) {
			throw new ServiceException("No data exists on server");
		}
		return metaData;
	}

	@Override
	public void saveEmployee(Employee employee) throws ServiceException {
		boolean validEmployee = validateEmployee(employee);
		if (validEmployee) {
			empDao.saveEmployee(employee);
		} else {
			throw new ServiceException("Invalid employee");
		}
	}

	private boolean validateEmployee(Employee employee) {
		boolean validEmployee = true;
		Competence competence = employee.getCompetence();
		Vertical vertical = employee.getvertical();
		Subpractice subpractice = employee.getSubpractice();

		if (competence == null || vertical == null || subpractice == null || competence.getIdcompetence() < 1
				|| subpractice.getIdsubpractice() < 1 || vertical.getIdvertical() < 1 || employee.getIdemployee() < 1
				|| employee.getEmployee_name() == null || employee.getEmployee_name().isEmpty()) {
			validEmployee = false;
		}
		return validEmployee;
	}

	@Override
	public List<EmployeeDto> findAllEmployees() throws ServiceException {
		List<EmployeeDto> dtos = empDao.findAllEmployees();
		if (dtos == null || dtos.size() == 0) {
			throw new ServiceException("No employees found");
		}
		return dtos;
	}

}
