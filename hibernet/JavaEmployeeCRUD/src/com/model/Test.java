package com.model;

import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		Operation o=new Operation();
		while(true)
		{
		System.out.println("1.Save Employee Details");
		System.out.println("2.Retrive Employee Records");
		System.out.println("3.Retrive Single Employee Details");
		System.out.println("4.Update Employee Details");
		System.out.println("5.Delete Employee Record");
		
		int key =sc.nextInt();
		
		switch (key) {
		case 1: o.savedeatils();
			break;
		
		case 2: o.retriveall();
		  break;
		
		case 3: o.singlerecord();
		  break;
		  
		case 4: o.updatedetails();
		break;
		
		case 5: o.deletedetails();
		break;

		default:
			System.out.println("Invalid Key You Entered");
			break;
		}
	}
}
}
