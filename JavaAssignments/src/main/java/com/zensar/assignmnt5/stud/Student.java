package com.zensar.assignmnt5.stud;

import com.zensar.assignmnt5.fact.Faculty;

public class Student {

	
	
	
	public static void main(String[]ar) {
	
		Faculty faculty = new Faculty();
		
		//only public scope method can be called from different packages
		faculty.getStudentsMaek(1);
	
	}
	
}
