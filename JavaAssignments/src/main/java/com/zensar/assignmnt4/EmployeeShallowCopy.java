package com.zensar.assignmnt4;

public class EmployeeShallowCopy implements Cloneable {

	 int id;
	 String empName;
	 Contact contact;
	
	 
	 public EmployeeShallowCopy(int id, String empName,Contact contact) {
		super();
		this.id = id;
		this.empName = empName;
		this.contact = contact;
	}
	 
	 
	 
	 
	 public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getEmpName() {
		return empName;
	}




	public void setEmpName(String empName) {
		this.empName = empName;
	}


      public void printEmail() {
    	  System.out.println("Email : "+contact.email);
      }

	// Default version of clone() method Creates Shallow Copy
	 @Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	 
	 
	
	
}
