package com.zensar.assignmnt3.dessert;

public class IceCream extends DessertItem {

	
	double tax =2.0;
	double cost = 120;
	static String name ="Ice-Cream";

	
	@Override
	double getCost() {
	  return cost +tax;
	}
}
