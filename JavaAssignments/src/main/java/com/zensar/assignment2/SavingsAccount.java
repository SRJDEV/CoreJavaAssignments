package com.zensar.assignment2;


public class SavingsAccount extends BankAccount implements CashCalcutate{

	protected double fixedDeposits;
	double cash;
	

	
	public SavingsAccount(double accountNumber, String accountType, double cash, double fixedDeposits) {
		super(accountNumber, accountType, cash);
		this.cash = cash + fixedDeposits;
		this.fixedDeposits = fixedDeposits;
	}


	
	
	public void availableCash(BankAccount account) {
		System.out.println("\tCash in Saving Account :"+cash);
		
	}

	
	
	}
