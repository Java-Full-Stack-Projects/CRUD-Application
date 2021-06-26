package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
			private static String  dburl = "jdbc:mysql://localhost:3306/jsp_crud?useSSL=false";
			private static String dbuname = "root";
			private static String dbpassword = "611";
			private static Connection con;
			
			public static Connection getConnection() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(dburl, dbuname,dbpassword);
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return con;
			}
}

