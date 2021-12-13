package com.zensar.assignmnt3.dessert;

public class Cookie extends DessertItem {


	double tax = 1.0;
	double costInDollar = 3;
	static String name = "Cookies";

	
	@Override
	double getCost() {
	  return (costInDollar +tax) * 70;
	}
	
}
