package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecordWithoutUserValue {
        static final String url="jdbc:mysql://localhost:3306/jfs32";
		static final String username="root";
		static final String pass="root";
		public static void main(String[] args) {
			try(Connection con=DriverManager.getConnection(url,username,pass);Statement st=con.createStatement()){
				
				String query="DELETE FROM EMPLOYEE WHERE ENO = 101";
				int res=st.executeUpdate(query);
				
				System.out.println(res+" rows deleted");
				
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
			}
			
		


}
