package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Scanner_Jdbc {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Fname: ");
		String Fname=sc.next();
		System.out.println("Enter Lname: ");
		String Lname=sc.next();
		System.out.println("Enter cust_id: ");
		String cust_id=sc.next();
		sc.close();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//getting the connection
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pkdb","root","root");
			//creating statement
			PreparedStatement stm;
			//inserting data into database
			@SuppressWarnings("unused")
			String sql="insert into customer values(?,?,?)";
			stm=conn.prepareStatement("inserted succesfully");
			stm.setString(2, Fname);
			stm.setString(3, Lname);
			stm.setString(1, cust_id);
			stm.execute();
			System.out.println("inserted succesfully");
			
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
