package com.employee.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Menu_Driven {
	Scanner sc=new Scanner(System.in);
	int Id,Age,Salary;
	String Name,City;
	//saving employee details in database
	public void saveMenuDriven() throws SQLException{
		System.out.println("Enter Employee Id: ");
		Id=sc.nextInt();
		System.out.println("Enter Employee Name: ");
		Name=sc.next();
		System.out.println("Enter Employee Age: ");
		Age=sc.nextInt();
		System.out.println("Enter Employee City: ");
		City=sc.next();
		System.out.println("Enter Employee Salary: ");
		Salary=sc.nextInt();
		Connection conn=Helper.con();
		PreparedStatement sl=conn.prepareStatement("insert into Menu_Driven values(?,?,?,?,?)");
		sl.setInt(1,Id);
		sl.setString(2, Name);
		sl.setInt(3,Age);
		sl.setString(4, City);
		sl.setInt(5, Salary);
		sl.executeUpdate();
		
	}
	//fetching employee details in database
	public void fetchMenuDriven() throws SQLException {
		Connection conn=Helper.con();
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from Menu_Driven");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getInt(5));
		}
		
	}
	//updating employee details in database
	public void updateMenuDriven() throws SQLException {
		Connection conn=Helper.con();
		Statement st=conn.createStatement();
		System.out.println("Enter Employee City: ");
		City=sc.nextLine();
		st.executeUpdate("update Menu_Driven set City = '"+City+"'+where Id="+Id);

		
	}
	//deleting employee details in database
	public void deleteMenuDriven() throws SQLException {
		Connection conn=Helper.con();
		Statement st=conn.createStatement();
		System.out.println("Enter Employee Id: ");
		Id=sc.nextInt();
		st.executeUpdate("delete from Menu_Driven where Id=" +Id);

	}
	

}
