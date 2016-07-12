package com.kn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kn.dto.EmployeeDto;
import com.kn.util.DBUtil;


public class EmployeeDao {

	public EmployeeDto findEmployee(String empID){
		EmployeeDto employee=new EmployeeDto();
		Connection con=DBUtil.getConnection();
		ResultSet rs = null;
		String sql = "SELECT idemployee,employee_name,competence_name,subpractice_name,verticals_name "
				+ "FROM employee,competence,subpractice,verticals "
				+ "WHERE employee.idcompetence=competence.idcompetence "
				+ "AND employee.idsubpractice=subpractice.idsubpractice "
				+ "AND employee.idverticals=verticals.idverticals "
				+ "AND employee.idemployee ="+ empID;
		try {
			Statement statement=con.createStatement();
			rs=statement.executeQuery(sql);
			if(rs.next()){
				employee.setmID(""+rs.getInt("idemployee"));
				employee.setName(rs.getString("employee_name"));
				employee.setCompetency(rs.getString("competence_name"));
				employee.setSubpractice(rs.getString("subpractice_name"));
				employee.setVertical(rs.getString("verticals_name"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.releaseResource(rs);
			DBUtil.releaseResource(con);
		}
		return employee;
	}
	
	public void saveEmployee(EmployeeDto employee){
		
		Connection con=DBUtil.getConnection();
		String sql="INSERT into employee (idemployee,employee_name,idcompetence,idsubpractice,idverticals)"
				+ "VALUES (?,?,"
				+ "(SELECT idcompetence FROM competence WHERE competence_name='"+employee.getCompetency()+"'),"
				+ "(SELECT idsubpractice FROM subpractice WHERE subpractice_name='"+employee.getSubpractice()+"'),"
				+ "(SELECT idverticals FROM verticals WHERE verticals_name='"+employee.getVertical()+"'))";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(employee.getmID()));
			ps.setString(2, employee.getName());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.releaseResource(con);
		}
	}
}
