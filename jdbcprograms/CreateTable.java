package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	static final String driver_name="com.mysql.cj.jdbc.Driver";
    static final String jdbc_url="jdbc:mysql://localhost:3306/jfs32";
    static final String userName="root";
    static final String password="root";
	public static void main(String[] args) {
				Connection connection=null;
				Statement statement=null;
				try {
					Class.forName(driver_name);
					connection=DriverManager.getConnection(jdbc_url,userName,password);
					statement=connection.createStatement();
					String sqlQuery="CREATE TABLE IF NOT EXISTS EMPLOYEE("
							+"ENO INT AUTO_INCREMENT PRIMARY KEY,"
							+"ENAME VARCHAR(100),"
							+"ESAL DECIMAL(10,2),"
							+"EADDR VARCHAR(50)" + ")";
					statement.execute(sqlQuery);
					System.out.println("Table created succesfully");
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					if(statement!=null) {
						try {
							statement.close();
						}catch(SQLException e) {
							e.printStackTrace();
						}
					}
					if(connection!=null) {
						try {
							connection.close();
						}catch(SQLException e) {
							e.printStackTrace();
						}
					}
				}

			}





}
