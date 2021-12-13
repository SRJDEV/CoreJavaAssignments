package com.zensar.assignment2;

public class Labour extends Employee {
	
	double overTime;
	double basic = 20000;

	public Labour(double overTime) {
		super();
		this.overTime = overTime;

	}
	
	@Override
	double calculateSalary() {
		// TODO Auto-generated method stub
		return basic+overTime;
	}

}
