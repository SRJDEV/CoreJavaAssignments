package com.zensar.assignmnt4;

public class InterfaceDemo {

	
	 static void printll() {
		 
		 Circle c = new Circle();
		 Employee e = new Employee();
		 
		 c.print();
		 e.print();
		 
	  }
 static void sortAll() {
		 
		 Circle c = new Circle();
		 Employee e = new Employee();
		 
		 c.sort();
		 e.sort();
		 
	  }
	
	public static void main(String[]ar) {
		
		
		printll();
		sortAll();
		
		
		Contact contact = new Contact("suraj@zensar.com");
		
		
		EmployeeDeepCopy empDeep = new EmployeeDeepCopy(123,"Suraj",contact);
		
		EmployeeDeepCopy deepCopy = null;
		
		try {
			deepCopy = (EmployeeDeepCopy) empDeep.clone();
		} catch (CloneNotSupportedException e1) {
		
			e1.printStackTrace();
		}
		

		System.out.println("\n::::::::::Deep Copy Example::::::::::::\n");
		
		System.out.println("Email: "+empDeep.contact.email);
		
		deepCopy.contact.email ="xxxxxxxxxxx";
		      
        System.out.println("Email :"+empDeep.contact.email); 
        
	      
        System.out.println("Email Deep Copy:"+deepCopy.contact.email); 
		
		
		
		EmployeeShallowCopy emp = new EmployeeShallowCopy(64222,"Suraj",contact);
		
		EmployeeShallowCopy empCopy = null;
		
		try {
			empCopy = (EmployeeShallowCopy) emp.clone();
				
		}
		catch (Exception e) {
		System.out.println("Exception");
		}
		
		
		System.out.println("::::::::::ShalowCopy Example::::::::::::\n");
		
	
		System.out.println("Email: "+emp.contact.email);
		
		empCopy.contact.email ="xxxxxxxxxxx";
		      
        System.out.println("Email :"+emp.contact.email); 
		
		
		
	}
}
