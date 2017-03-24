package com.dante.studentmanage.util;

import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


import com.mysql.jdbc.Driver;

public class DBUtil {
	private static String DRIVER;
	private static String DBURL;
	private static String USER;
	private static String PASSWORD;
	private static Connection connection = null;
	/*
	 * 加载配置文件
	 */
	static {
		InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("DBUtil.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("==========配置文件读取错误============");
		}
		DRIVER = properties.getProperty("DRIVER");
		DBURL = properties.getProperty("DBURL");
		USER = properties.getProperty("USER");
		PASSWORD = properties.getProperty("PASSWORD");
	}

	/*
	 * 获取链接
	 */
	public static Connection makeConnection() {
		try {
			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(PreparedStatement ps1, Connection conn) {
		try {
			if (ps1 != null) {
				ps1.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void roll(PreparedStatement ps,Connection connection,Exception e) {
		try {
			connection.setAutoCommit(false);
			connection.rollback();
			System.out.println("============回滚事务成功==========");
			connection.setAutoCommit(true);
			DBUtil.closeConnection(ps, connection);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.printStackTrace();
	}

	public static void roll(PreparedStatement ps, Connection connection2, SQLException e) {
		// TODO Auto-generated method stub
		
	} 
}
