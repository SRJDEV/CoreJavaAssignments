package com.zensar.assignmnt4;

public class EmployeeDeepCopy implements Cloneable{

	 int id;
	 String empName;
	 Contact contact;
	
	 
	 public EmployeeDeepCopy(int id, String empName, Contact contact) {
		super();
		this.id = id;
		this.empName = empName;
		this.contact =contact;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		  EmployeeDeepCopy emp = (EmployeeDeepCopy) super.clone();
	      emp.contact = (Contact) contact.clone();
	      return emp;
	}
	
	
}
