package com.kn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.kn.dto.EmployeeDto;
import com.kn.entity.Employee;
import com.kn.exception.DaoException;
import com.kn.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public EmployeeDto findEmployee(int mID) throws DaoException {
		EmployeeDto employee = new EmployeeDto();
		Connection con = null;
		Statement statement = null;
		String sql = "SELECT idemployee,employee_name,competence_name,subpractice_name,vertical_name "
				+ "FROM employee,competence,subpractice,vertical "
				+ "WHERE employee.idcompetence=competence.idcompetence "
				+ "AND employee.idsubpractice=subpractice.idsubpractice "
				+ "AND employee.idvertical=vertical.idvertical " + "AND employee.idemployee =" + mID;
		try {
			con = DBUtil.getConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				employee.setmID("" + rs.getInt("idemployee"));
				employee.setName(rs.getString("employee_name"));
				employee.setCompetency(rs.getString("competence_name"));
				employee.setSubpractice(rs.getString("subpractice_name"));
				employee.setVertical(rs.getString("vertical_name"));
			}

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DBUtil.releaseResource(con, statement);
		}
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) throws DaoException {

		String sql = "INSERT into employee (idemployee,employee_name,idcompetence,idsubpractice,idvertical) VALUES (?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, employee.getIdemployee());
			ps.setString(2, employee.getEmployee_name());
			ps.setInt(3,employee.getCompetence().getIdcompetence());
			ps.setInt(4,employee.getSubpractice().getIdsubpractice());
			ps.setInt(5,employee.getvertical().getIdvertical());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DBUtil.releaseResource(con, ps);
		}
	}
}
