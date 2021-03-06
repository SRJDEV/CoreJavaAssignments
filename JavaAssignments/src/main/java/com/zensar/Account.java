package com.zensar;

import com.zensar.assignmnt6.InsufficientBalanceException;

public class Account {
	private int id;
	private double balance;

	Account() {
	    id = 0;
	    balance = 0.0;
	}

	Account (int id, double balance) {
	this.id =id;
	this.balance = balance;
	}
	
	
	public int getId() {
	    return id;
	}
	public double getBalance() {
	    return balance;
	}
	
	public void setId (int newId) { 
	    id = newId;
	}
	public void setBalance (double newBalance) {
	    balance = newBalance;
	}
	

	double withdraw (double amount) throws InsufficientBalanceException {  
		if(amount>balance) {
			throw new InsufficientBalanceException("Insufficient Balance in Account");
			
		}else {
	    
			return balance -= amount;
		}
	}
	 
	double deposit(double amount) {
	    return balance += amount;
	}

	    public static void main(String[] args) {
	      
	    	Account account1 = new Account (64222, 20000); 
	   

	        System.out.println("Account ID:" + " " + account1.id);
	        System.out.println("Balance:" + account1.getBalance());
            
	        double withdrawAmount = 23000;
	        System.out.println("Withdrawing "+withdrawAmount);
	        
	        try {
				account1.withdraw(21000);
			} catch (InsufficientBalanceException e) {
				System.out.println("Caught exception ");
				  System.out.println("Exception occured: " + e);  
				
			}
	        
	        double depositAmount = 3000;
	        
	        System.out.println("Making Deposit of "+depositAmount);
	        System.out.println("Balance after deposit" + " " + account1.deposit(3000));
	   
	    }

	}
