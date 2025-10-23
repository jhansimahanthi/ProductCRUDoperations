package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTableRecords {
	static final String jdbc_Url = "jdbc:mysql://localhost:3306/jfs32";
	static final String userName = "root";
	static final String password = "root";

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(jdbc_Url, userName, password);
				Statement statement = connection.createStatement()) {

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter no.of records to insert");
			int numberOfRecords = sc.nextInt();
			for (int i = 0; i < numberOfRecords; i++) {
				System.out.println("Enter details for Record : " + (i + 1));
				System.out.println("Enter employee number");
				int eno = sc.nextInt();
				System.out.println("Enter employee name");
				String ename = sc.next();
				System.out.println("Enter employee salary ");
	 			double esal = sc.nextDouble();
				System.out.println("Enter employee Address");
				String eaddr = sc.next();

				String insertSql = "insert into employee(eno,ename,esal,eaddr)" + "values(" + eno + ",'" + ename + "',"
						+ esal + ",'" + eaddr + "')";
				int rowsAffected = statement.executeUpdate(insertSql);
				if (rowsAffected == 1) {
					System.out.println("Record" + (i + 1) + " inserted succesfully");

				} else {
					System.out.println("Failed to insert record");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
