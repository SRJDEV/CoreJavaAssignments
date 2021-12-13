package com.zensar.assignmnt4;

import java.util.Comparator;

class SortByName implements Comparator<Person> {

	public int compare(Person p1, Person p2) {
		
		
		return p1.name.toUpperCase().compareTo(p2.name.toUpperCase());
	}
	
}
