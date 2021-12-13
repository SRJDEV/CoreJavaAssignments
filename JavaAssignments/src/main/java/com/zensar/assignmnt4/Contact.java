package com.zensar.assignmnt4;

public class Contact implements Cloneable {
	
	String email;

	public Contact(String email) {
		super();
		this.email = email;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	

}
