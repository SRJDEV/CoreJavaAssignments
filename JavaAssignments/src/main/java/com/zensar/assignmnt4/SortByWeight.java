package com.zensar.assignmnt4;

import java.util.Comparator;

class SortByWeight implements Comparator<Person> {

	public int compare(Person p1, Person p2) {
		
		if(p1.weight == p2.weight)
			return 0;
		else if(p1.weight > p2.weight)
			return 1;
		
		else 
		return -1;
	}
	
}
