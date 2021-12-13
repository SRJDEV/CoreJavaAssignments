package com.zensar.assignment2;
public class CurrentAccount extends BankAccount implements CashCalcutate {

	protected double cashCredit;
    double cash;
	public CurrentAccount(double accountNumber, String accountType, double cash, double cashCredit) {
		super(accountNumber, accountType, cash);
		this.cash = cash + cashCredit;
		this.cashCredit = cashCredit;

	}
	public void availableCash(BankAccount account) {
		System.out.println("\tCash in Current Account :"+cash);
		
	}
	
  


}

