package com.util;

import java.sql.*;

public class DBConnection {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver"; // definition of database driver
	private static final String DBURL = "jdbc:MySQL://localhost:3306/db_affairemanagement"; // definition of database url
	private static final String DBUSER = "root"; // definition of database username
	private static final String DBPASSWORD = "lynone94"; // definition of database password
	public static Connection getConnection(){
		Connection conn = null; // declaration of a connection
		try{
			Class.forName(DBDRIVER); // registration of driver
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); // get a connection
		}catch(ClassNotFoundException e){
			e.printStackTrace(); // driver not found exception
			System.out.println("Class not found!");
		}catch(SQLException e){
			System.out.println("Connection Failed! Please try again");; // sql exception
		}
		return conn;
	}
	public static void closeConnection(Connection conn){
		if(conn != null){
			try{
				conn.close(); // close a connection
			}catch(SQLException e){
				System.out.println("Close failed! Please try again");; // sql exception
			}
		}
	}
	public static void closePreparedStatement(PreparedStatement p){
		if(p != null){
			try{
				p.close(); // close a prepared statement
			}catch(SQLException e){
				e.printStackTrace(); // sql exception
			}
		}
	}
	public static void closeResultSet(ResultSet r){
		if(r != null){
			try{
				r.close(); // close a result set
			}catch(SQLException e){
				e.printStackTrace(); // sql exception
			}
		}
	}
}
