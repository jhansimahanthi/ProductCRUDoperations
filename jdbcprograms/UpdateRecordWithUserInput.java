package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecordWithUserInput {
	 static final String url="jdbc:mysql://localhost:3306/jfs32";
		static final String username="root";
		static final String pass="root";
		static void display() {
			try (Connection con = DriverManager.getConnection(url, username, pass); Statement st = con.createStatement()) {

				String query = "SELECT *FROM EMPLOYEE";
				ResultSet res = st.executeQuery(query);
				System.out.println("ENO\tENAME\t\t\tESAL\tEADDR");
				System.out.println("-------------------------------------------");
				while (res.next()) {
					int eno = res.getInt(1);
					String ename = res.getString(2);
					String nm = ename.trim();
					double sal = res.getDouble(3);
					String addr = res.getString(4);

					System.out.println(eno + "\t" + nm + "\t\t" + sal + "\t" + addr);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		public static void main(String[] args) {
				display();
				Scanner sc=new Scanner(System.in);
				
				try(Connection con=DriverManager.getConnection(url,username,pass);Statement st=con.createStatement()){
					System.out.println("Enter eno to update");
					int eno=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Updated Employee Name");
					String ename=sc.nextLine();
					System.out.println("Enter updated Employee Salary");
					double esal=sc.nextDouble();
					System.out.println("Enter updated Employee Address");
					String add=sc.next();
					
					String query="UPDATE EMPLOYEE SET ENAME='"+ename+"',ESAL="+esal+",EADDR='"+add+"' WHERE ENO ="+eno;
					int res=st.executeUpdate(query);
					
					System.out.println(res+" rows deleted");
					
					}
				catch(SQLException e) {
					e.printStackTrace();
				}
			display();
			sc.close();
		}

	
}
