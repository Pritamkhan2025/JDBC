package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_test {

	public static void main(String[] args) {
		try {
			//register driver step no 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			//getting the connection step 2
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pkdb","root","root");
			//create statement step 3
			Statement stmt=conn.createStatement();
			//execute query fetch data from database step no 4
			ResultSet rs=stmt.executeQuery("select * from customer");
			//iteration
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(1));
			}
			//close database connection step 5
			conn.close();
			
		}
		catch(Exception e) {//exception handling
			System.out.println(e);
		}
	}
}

