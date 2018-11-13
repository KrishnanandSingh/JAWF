package com.kn.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kn.dao.EmployeeDao;
import com.kn.dao.MetaDataDao;
import com.kn.dto.EmployeeDto;
import com.kn.dto.MetaData;
import com.kn.entity.Competence;
import com.kn.entity.Employee;
import com.kn.entity.Subpractice;
import com.kn.entity.Vertical;
import com.kn.exception.DaoException;
import com.kn.exception.ServiceException;

public class EmployeeServiceTest {
	private static EmployeeDao employeeDao;
	private static MetaDataDao metaDataDao;
	private static EmployeeService employeeService;
	static List<Employee> employees;
	static List<Competence> competences;
	static List<Vertical> verticals;
	static List<Subpractice> subpractices;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		metaDataDao = new MetaDataDao() {

			@Override
			public MetaData getData() throws DaoException {
				MetaData metaData = new MetaData(competences, subpractices, verticals);
				return metaData;
			}
		};
		employeeDao = new EmployeeDao() {

			@Override
			public void saveEmployee(Employee employee) throws DaoException {
				employees.add(employee);
			}

			@Override
			public EmployeeDto findEmployee(int mID) throws DaoException {
				EmployeeDto employeeDto = null;
				Employee foundEmployee = null;
				for (Employee employee : employees) {
					if (employee.getIdemployee() == mID) {
						foundEmployee = employee;
						break;
					}
				}
				if (foundEmployee != null) {
					employeeDto = new EmployeeDto();
					employeeDto.setCompetency(foundEmployee.getCompetence().getCompetence_name());
					employeeDto.setmID(foundEmployee.getIdemployee());
					employeeDto.setName(foundEmployee.getEmployee_name());
					employeeDto.setSubpractice(foundEmployee.getSubpractice().getSubpractice_name());
					employeeDto.setVertical(foundEmployee.getvertical().getVertical_name());
				}
				return employeeDto;
			}

			@Override
			public List<EmployeeDto> findAllEmployees() throws DaoException {
				List<EmployeeDto> employeeDtos = new ArrayList<>();
				for (Employee employee : employees) {
					EmployeeDto empdto = new EmployeeDto();
					empdto.setmID(employee.getIdemployee());
					empdto.setName(employee.getEmployee_name());
					empdto.setCompetency(employee.getCompetence().getCompetence_name());
					empdto.setSubpractice(employee.getSubpractice().getSubpractice_name());
					empdto.setVertical(employee.getvertical().getVertical_name());
					employeeDtos.add(empdto);
				}
				return employeeDtos;
			}
		};
		employeeService = new EmployeeServiceImpl();
		((EmployeeServiceImpl) employeeService).setEmpDao(employeeDao);
		((EmployeeServiceImpl) employeeService).setMetadao(metaDataDao);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		employeeDao = null;
		metaDataDao = null;
	}

	@Before
	public void setUpBeforeTest() {
		subpractices = new ArrayList<>();
		verticals = new ArrayList<>();
		employees = new ArrayList<>();
		competences = new ArrayList<>();

		Subpractice subpractice1 = new Subpractice(1, "Automation Testing");
		Subpractice subpractice2 = new Subpractice(2, "Performance Testing");
		Subpractice subpractice3 = new Subpractice(3, "Functional Testing");
		Subpractice subpractice4 = new Subpractice(4, "Digital Testing");
		subpractices.add(subpractice1);
		subpractices.add(subpractice2);
		subpractices.add(subpractice3);
		subpractices.add(subpractice4);

		Vertical vertical1 = new Vertical(1, "TTH");
		Vertical vertical2 = new Vertical(2, "RCM");
		Vertical vertical3 = new Vertical(3, "BFSI");
		Vertical vertical4 = new Vertical(4, "COE");
		verticals.add(vertical1);
		verticals.add(vertical2);
		verticals.add(vertical3);
		verticals.add(vertical4);

		Competence competence1 = new Competence(1, "C1");
		Competence competence2 = new Competence(2, "C2");
		Competence competence3 = new Competence(3, "C3");
		Competence competence4 = new Competence(4, "C4");
		Competence competence5 = new Competence(5, "C5");
		Competence competence6 = new Competence(6, "C6");
		Competence competence7 = new Competence(7, "C7");
		Competence competence8 = new Competence(8, "C8");
		Competence competence9 = new Competence(9, "C9");
		competences.add(competence1);
		competences.add(competence2);
		competences.add(competence3);
		competences.add(competence4);
		competences.add(competence5);
		competences.add(competence6);
		competences.add(competence7);
		competences.add(competence8);
		competences.add(competence9);

		Employee chitkarsh = new Employee(1027353, "Chitkarsh Gandhi", competence2, subpractice2, vertical4);
		Employee ankit = new Employee(1028097, "Ankit Kasera", competence1, subpractice2, vertical4);
		Employee krishna = new Employee(1028099, "Krishnanand Singh", competence1, subpractice2, vertical4);

		employees.add(chitkarsh);
		employees.add(ankit);
		employees.add(krishna);
	}

	@Test
	public final void testFindEmployee() throws ServiceException {
		int mid = 1028099;
		EmployeeDto actual = employeeService.findEmployee(mid);
		EmployeeDto expected = new EmployeeDto("Krishnanand Singh", mid, "C1", "Performance Testing", "COE");
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = ServiceException.class)
	public final void testFindEmployeeNe() throws ServiceException {
		int mid = 1028010;
		employeeService.findEmployee(mid);
	}

	@Test
	public final void testGetMetaData() throws ServiceException {
		MetaData meta = employeeService.getMetaData();
		List<Competence> competences = meta.getCompetence();
		List<Subpractice> subpractices = meta.getSubpractice();
		List<Vertical> verticals = meta.getVertical();

		Assert.assertTrue(EmployeeServiceTest.competences.size() == competences.size());
		boolean competenceEqualsCondition = EmployeeServiceTest.competences.containsAll(competences);
		Assert.assertTrue(competenceEqualsCondition);

		Assert.assertTrue(EmployeeServiceTest.subpractices.size() == subpractices.size());
		boolean subpracticesEqualsCondition = EmployeeServiceTest.subpractices.containsAll(subpractices);
		Assert.assertTrue(subpracticesEqualsCondition);

		Assert.assertTrue(EmployeeServiceTest.verticals.size() == verticals.size());
		boolean verticalsEqualsCondition = EmployeeServiceTest.verticals.containsAll(verticals);
		Assert.assertTrue(verticalsEqualsCondition);

	}

	@Test(expected = ServiceException.class)
	public final void testGetMetaDataNe() throws ServiceException {
		EmployeeServiceTest.competences = new ArrayList<>();
		EmployeeServiceTest.subpractices = new ArrayList<>();
		employeeService.getMetaData();
	}

	@Test(expected = ServiceException.class)
	public final void testSaveEmployeeNe() throws ServiceException {
		Subpractice subpractice1 = new Subpractice(1, "Automation Testing");
		Vertical vertical4 = new Vertical(0, "COE");
		Competence competence1 = new Competence(1, "C1");
		Employee newEmployee = new Employee(1028099, "New Employee", competence1, subpractice1, vertical4);
		employeeService.saveEmployee(newEmployee);
	}

	@Test
	public final void testSaveEmployee() throws ServiceException {
		Subpractice subpractice1 = new Subpractice(1, "Automation Testing");
		Vertical vertical4 = new Vertical(1, "COE");
		Competence competence1 = new Competence(1, "C1");
		Employee newEmployee = new Employee(1028010, "New Employee", competence1, subpractice1, vertical4);
		employeeService.saveEmployee(newEmployee);
		EmployeeDto empDto = employeeService.findEmployee(1028010);
		Assert.assertNotNull(empDto);
		EmployeeDto expected = new EmployeeDto("New Employee", 1028010, "C1", "Automation Testing", "COE");
		Assert.assertEquals(expected, empDto);
	}

}
