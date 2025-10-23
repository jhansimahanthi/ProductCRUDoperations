package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTableExample {
	static final String jdbc_Url = "jdbc:mysql://localhost:3306/jfs32";
	static final String userName = "root";
	static final String password = "root";

	public static void main(String[] args) {
		try (Connection connection=DriverManager.getConnection(jdbc_Url, userName, password);
				Statement statement = connection.createStatement()) {
			String sql = "Drop TABLE IF EXISTS EMPLOYEE";
			statement.executeUpdate(sql);
			System.out.println("Table deleted succesfully");
	}catch(SQLException e){
		e.printStackTrace();
	
		}
		

	}

}
