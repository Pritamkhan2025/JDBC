package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Inserted_Jdbc {

	public static void main(String[] args) {
		try {
			//register driver step no 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			//getting the connection step 2
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pkdb","root","root");
			//create statement step 3
			Statement stmt=conn.createStatement();
			stmt.executeUpdate("insert into customer value(7,'Divya','Agarbal')");
			System.out.println("inserted succesfully....");
			//close database connection step 5
			conn.close();
			
		}
		catch(Exception e) {//exception handling
			System.out.println(e);
		}

	}

}
