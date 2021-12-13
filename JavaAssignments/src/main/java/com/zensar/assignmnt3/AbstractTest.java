package com.zensar.assignmnt3;

   abstract class AbstractTest {

	
	//This can not be done without making class as abstract
	//abstract void myAbstractMethod();
	//can not mark the abstract class as private
	//can not mark abstract class as final, if marked it throws error as
    //The class AbstractTest can be either abstract or final, not both  
   //We can make print as non abstract method although the class is abstract 
	  abstract void print();
	  
	
	  
	
	public static void main(String[]arg) {
		
		
		//hence we can not instantiate the abstract class
		//AbstractTest t = new  AbstractTest();
		
	}
	
	 
	
}
