package com.sqldata;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetRow;

public class sqlLogin {
	
/*	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		new sqlLogin();
	}*/
	
	
	static final String JDBC_Driver="com.mysql.jdbc.driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/test";
	
	static final String User="root";
	static final String PASS="358599";
	
	
	public ResultSet sqlLogin(String sql) throws SQLException {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList list=new ArrayList<>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//open the link
			System.out.println("open the link....");
			conn=DriverManager.getConnection(DB_URL, User, PASS);
			
			//execute select
			System.out.println("instantiate Statement objector...");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);

			/*while(rs.next()) {
				String username=rs.getString("username");
				String password=rs.getString("password");
				
				System.out.println(username);
				System.out.println(password);
				
			}*/
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		return rs;

	}

}
