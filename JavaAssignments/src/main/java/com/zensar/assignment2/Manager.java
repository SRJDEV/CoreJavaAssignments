package com.zensar.assignment2;

public class Manager extends Employee {

	
	double incentive;
	double basic= 70000;

	public Manager(double incentive) {
		super();
		this.incentive = incentive;
		
	}
	
	@Override
	double calculateSalary() {
        
		return basic+incentive;
	}
}
