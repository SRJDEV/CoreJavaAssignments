package com.zensar.assignmnt5;

public class StringExample {

	
	String s = "ABC";
	String s1 = new String("ABC");
	
	
	void checkWithOperator() {
	 System.out.println("check with ==  operator  : "+(s ==s1));
	
	}
	
	void checkWithMethod() {
	 System.out.println("check with .equals method: " +s.equals(s1));// .equals for content comparison
	}
		
	
	public static void main(String[]arg) {
		
		StringExample s = new StringExample();
	
		s.checkWithOperator();
		s.checkWithMethod();
		
	  //s
	}
	
}
