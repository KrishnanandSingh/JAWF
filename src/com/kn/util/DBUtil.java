package com.kn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private static final String DRIVER = Configs.getString("driver");
	private static final String URL = Configs.getString("url");
	private static final String USER = Configs.getString("user");
	private static final String PWD = Configs.getString("password");

	/**
	 * private default constructor to prevent instantiation of utility class
	 */
	private DBUtil() {
	}

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.err
					.println("class " + DRIVER + " not found, is the library present in classpath? " + e.getMessage());
		}
	}

	/**
	 * 
	 * @return database connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PWD);
	}

	/**
	 * When a Statement object is closed, its current ResultSet object, if one
	 * exists, is also closed
	 * 
	 * @param ps
	 *            statement to release
	 */
	public static void releaseResource(Statement stat) {
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				System.err.println("couldn't release statment, " + e.getMessage());
			}
		}
	}

	/**
	 * When a Statement object is closed, its current ResultSet object, if one
	 * exists, is also closed
	 * 
	 * @param ps
	 *            statement to release
	 */
	public static void releaseResource(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				System.err.println("couldn't release statment, " + e.getMessage());
			}
		}
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
				System.err.println("couldn't release Connection, " + e.getMessage());
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
				System.err.println("couldn't release resultset, " + e.getMessage());
			}
		}
	}

	public static void releaseResource(Connection con, Statement stat, PreparedStatement ps) {
		releaseResource(con);
		releaseResource(stat);
		releaseResource(ps);
	}

	public static void releaseResource(Connection con, Statement stat) {
		releaseResource(con);
		releaseResource(stat);
	}

}
