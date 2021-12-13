package com.zensar.assignmnt3;

public class MySingleton {

	
	
	private static MySingleton instance = null;
	
	private MySingleton() {
		
	}
	
	public static MySingleton getInstance() {
		
		if(instance == null) {
			instance = new MySingleton();
		}
		return instance;
	}
	
	public static void main(String[]args) {

    	
  	  //we can not instantiate the singleton class as 
  	 //it has only constructor which is private
  	
  	//MySingleton singleton = new MySingleton(); ---> we can not do this
  	
      MySingleton singleton =	 MySingleton.getInstance();
      MySingleton singleton2 = MySingleton.getInstance();
      
      System.out.println(singleton == singleton2);
      
      //to confirm we have achieved singleton
      System.out.println(singleton.hashCode());
      System.out.println(singleton2.hashCode());
	}
}
