package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update_Jdbc {

	public static void main(String[] args) {
		try {
			//register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//getting the connection
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306//pkdb","root","root");
			Statement stmt=conn.createStatement();
			//executing update query
			stmt.executeUpdate("update customer set Lname='Banerjee' where cust_id='A02'");
			//executing delete queary
			stmt.executeUpdate("delete from customer where cust_id='A03'");
			//executing query
			ResultSet rs=stmt.executeQuery("select * from customer");
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
