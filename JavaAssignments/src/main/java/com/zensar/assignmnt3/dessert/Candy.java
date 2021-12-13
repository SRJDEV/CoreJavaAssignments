package com.zensar.assignmnt3.dessert;

public class Candy extends DessertItem {

   	static double tax =1.0;
	static double costInDollar = 2;
 	static String name = "Candies";

	
	@Override
	double getCost() {
	  return (costInDollar +tax) * 60;
	}
	

}
