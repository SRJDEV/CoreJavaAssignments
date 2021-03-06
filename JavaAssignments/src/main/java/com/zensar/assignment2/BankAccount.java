package com.zensar.assignment2;

public class BankAccount {

	
	protected double accountNumber;
	protected String accountType;
	protected double cash;
    
	
	public BankAccount() {
		
	}
   
	public BankAccount(double accountNumber, String accountType, double cash) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.cash = cash;
	}

	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", cash=" + cash + "]";
	}

	public static void main(String args[]) {
		
		SavingsAccount sb = new SavingsAccount(64222,"saving", 1000.00,9000.00);
		sb.availableCash(sb);
		
		CurrentAccount ca = new CurrentAccount(64888,"current", 3000.25,50000.00);
		ca.availableCash(ca);
		
		BankAccount ac = new BankAccount();
		ac.cash = sb.cash + ca.cash;
		System.out.println("\n\t Total Cash in Bank : "+ac.cash );
	}

	
}
