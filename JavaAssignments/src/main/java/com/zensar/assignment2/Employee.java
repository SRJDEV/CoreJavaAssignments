package com.zensar.assignment2;

public class Employee {
 
	
 double calculateSalary() {
	 
	 return 0.0;
 }
 
 public static void main(String[]ar) {
	 
	 Manager manager = new Manager(1500);
	 Labour labour = new Labour(500);
	 System.out.println("Salary of Manager : "+manager.calculateSalary());
	 System.out.println("Salary of Labour : "+labour.calculateSalary());
	 
	 
 }
}
