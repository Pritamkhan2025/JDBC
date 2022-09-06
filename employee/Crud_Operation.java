package com.employee.menu;

import java.util.Scanner;
import java.sql.SQLException;

public class Crud_Operation {
	public static void main(String args[]) throws SQLException{
		Menu_Driven e=new Menu_Driven();
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int ch;
		do {
			System.out.println("1. INSERT \n2. DISPLAY \n3. UPDATE \n4. DELETE \n5. EXIT");
			System.out.println("Enter your choice from 1 to 5");
			ch=Integer.parseInt(sc.nextLine());
			System.out.println("---------------------");
			switch(ch) {
			case 1:
				e.saveMenuDriven();
				break;
			case 2:
				e.fetchMenuDriven();
				break;
			case 3:
				e.updateMenuDriven();
				break;
			case 4:
				e.deleteMenuDriven();
				break;	
			case 5:
				System.exit(0);;
				break;	
			}
			
		}while (ch!=5);
		
	}

}
