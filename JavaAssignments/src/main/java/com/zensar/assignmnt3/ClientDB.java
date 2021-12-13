package com.zensar.assignmnt3;

public class ClientDB {

	
	public static void main(String[]arg) {
		
		
	Persistance persistance =	Persistance.getPersistanceInstance();

	if(persistance!=null) {
		
		persistance.persist();
	}
		
	}
	
}
