package com.sqldata;

import java.sql.*;
import java.util.ArrayList;

public class sqlRegister {
	static final String JDBC_Driver="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/test";
	
	static final String USER="root";
	static final String PASS="358599";
	
	PreparedStatement psmt=null;
	Connection con=null;
	
	public PreparedStatement sqlRegister(String sql) throws SQLException {

		try {

			Class.forName(JDBC_Driver);
			System.out.println("link is open....");
			con=DriverManager.getConnection(DB_URL, USER, PASS);
			
			System.out.println("instantiate Statement objector...");
			psmt=con.prepareStatement(sql);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		return psmt;
		
	}

}
