package com.kn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/employee_sdet";
	private static final String USER = "root";
	private static final String PWD = "Welcome123";

	/**
	 * private default constructor to prevent instantiation of utility class
	 */
	private DBUtil() {
	}

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return database connection
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param ps
	 *            statement to release
	 */
	public static void releaseResource(Statement ps) {
	}

	/**
	 * 
	 * @param con
	 *            connection to release
	 */
	public static void releaseResource(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param rs
	 *            result set to release
	 */
	public static void releaseResource(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
