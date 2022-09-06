package com.student.menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Student_Menu_Driven {//main class
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {    // main method
		Student_Menu_Driven dr = new Student_Menu_Driven(); // create an object of the class
		Scanner sc = new Scanner(System.in); 
		int ch;
		do {
			System.out.println("1. INSERT \n2. DISPLAY \n3. UPDATE \n4. DELETE \n5. EXIT");
			System.out.println("Enter your choice from 1 to 5");

			ch = sc.nextInt();	// read the user input

			switch(ch) {
			case 1: 
				dr.insertData();
				break;
			case 2:
				dr.displayData();
				break;
			case 3:
				dr.updateData();
				break;
			case 4:	
				dr.deleteData();
				break;
			case 5:
				System.out.println("Thank You!");				
			default:
				break;
			}
			
		} while (ch != 5);	
		
	}
	
	// declare a method for connection
	public Connection getConnection() {
		try {
			// register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// get connection 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pkdb","root","root");
			return conn;
		} catch (Exception e) {	
			System.out.println(e);
		}
		return null;
	}
	
	// declare a method for insert the data
	@SuppressWarnings("resource")
	public void insertData() {
		// creating scanner objects
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		
		Student s = new Student();	// create a  object of the class
		
		System.out.print("Enter Id: ");
		s.setid(sc1.nextInt());

		System.out.print("Enter Name: ");
		s.setname(sc2.nextLine());

		System.out.print("Enter Address: ");
		s.setaddress(sc3.nextLine());

		System.out.print("Enter Phone No: ");
		s.setphone (sc4.nextInt());
		try {
			// call getConnection() method
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pkdb","root","root");
			String sql = ("insert into student values(?,?,?,?)");
			PreparedStatement ps = conn.prepareStatement(sql);
			// get all data insert into table
			ps.setInt(1, s.getid());
			ps.setString(2, s.getname());
			ps.setString(3, s.getaddress());
			ps.setInt(4, s.getphone ());
			// execute the statement
			ps.execute();
			System.out.println("inserted succesfully...");
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Duplicate entry!"+e);
		}
		
	}

	// create a method for display the data
	public void displayData() {
		try {
			// called getConnection() method
			Connection conn = getConnection();
			//displaying data in database table
			PreparedStatement ps = conn.prepareStatement("select * from student");
			//execute query fetch data from database
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// declare a method for delete the data
	@SuppressWarnings("resource")
	public void deleteData() {
		try {
			Scanner sc5 = new Scanner(System.in);
			System.out.print("Enter id to delete: ");
			int id = sc5.nextInt();
			// called the connection method
			Connection conn = getConnection();
			//deleting data in database table
			PreparedStatement ps = conn.prepareStatement("delete from student where id = ?");
			ps.setInt(1, id);
			
			// execute for update
			int n = ps.executeUpdate();
			// condition to check operation done or not
			if(n==1) { 
				System.out.println("Deleted successfully");
			}
			else {
				System.out.println("Data not match");
			}
			// close objects
			ps.close();
			conn.close();
		// catch block	
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	// method to update the data
	@SuppressWarnings("resource")
	public void updateData() {
		// created scanner object
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		// created a student class object
		Student st = new Student();

		System.out.print("Enter ID to update: ");
		int id = sc1.nextInt();
		st.setid(id);

		System.out.print("Enter Name to update: ");
		String name = sc2.nextLine();
		st.setname(name);

		System.out.print("Enter Address to update: ");
		String address = sc3.nextLine();
		st.setaddress(address);

		System.out.print("Enter Phone No to update: ");
		int num = sc4.nextInt();
		st.setphone (num);

		try {
			// called getConnection() method
			Connection conn = getConnection();
			//updating data in database table
			String s = ("update student set (?,?,?,?)");
			PreparedStatement ps = conn.prepareStatement(s);
			
			// get all data
			ps.setString(1, st.getname());
			ps.setString(2, st.getaddress());
			ps.setInt(3, st.getphone());
			ps.setInt(4, st.getid());
			// execute for update
			int n = ps.executeUpdate();
			ps.close();
			conn.close();
			// condition to check the update done or not
			if(n==1) {
				System.out.println("Updated successfully");
			}
			else {
				System.out.println("Not updated");
			}

		} catch (Exception e) {	
			System.out.println(e);
		}
	}
	

}
