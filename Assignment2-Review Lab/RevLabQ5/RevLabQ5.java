package revlabq5;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RevLabQ5 {
	
	public static void main(String[] args) {
		// Test Program
		Account account = new Account("George", 1122, 1000);
		account.setAnnualInterestRate(1.5);

		System.out.println("       Account Summary"); 
		System.out.println("------------------------------------");
		System.out.println("Account holder name: " + account.getName());
		System.out.println("Account holder ID: " + account.getId());
		System.out.println("Annual interest rate: " + account.getAnnualInterestRate() + "%");
		System.out.printf("Openning balance: $%.2f\n", account.getBalance());
		System.out.println("Date Created: " + account.getDateCreated());
		
		account.deposit(30);
		account.deposit(40);
		account.deposit(50);
		account.withdraw(5);
		account.withdraw(4);
		account.withdraw(2);
		
		System.out.printf("New balance: $%.2f\n", account.getBalance());
		System.out.println("\n     List of transactions");
		System.out.println("------------------------------------");
		for (int i = 0; i < account.getTransactions().size(); i++) {
			System.out.println("Date: " + 
				(account.getTransactions()).get(i).getDate());
			System.out.println("Type: " + 
				(account.getTransactions()).get(i).getType());
			System.out.println("Amount: " + 
				(account.getTransactions()).get(i).getAmount());
			System.out.println("Balance: " + 
				(account.getTransactions()).get(i).getBalance());
			System.out.println("Description: " + 
				(account.getTransactions()).get(i).getDescription());
			System.out.println();
		}
	}
}

class Account {
	private String name = "";
	private int id = 0;
	private double balance = 0.0;
	private double annualInterestRate = 0.0;
	private Date dateCreated = new Date();
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	public Account() {
		this.dateCreated = new Date();
	}
	
	public Account(String name, int id, double balance) {
		this.name = name;
		this.id = id;
		this.balance = balance;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getId() {
		return this.id;
	}
	 
	public double getBalance( ) {
		return this.balance;
	}
	
	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}
	
	public String getDateCreated() {
		SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/yyyy");
		String dateStr = sdf.format(dateCreated);
		return dateStr;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public double getMonthlyInterestRate() {
		return (annualInterestRate / 100) / 12;
	}
	
	public double getMonthlyInterest() {
		return balance * getMonthlyInterestRate();
	}
	
	public void withdraw(double amount) {
		this.balance -= amount;
		transactions.add(new Transaction('W', amount, balance, 
				"Withdrawal from account"));
	}
	
	public void deposit(double amount) {
		this.balance += amount;
		transactions.add(new Transaction('D', amount, balance, 
				"Deposit to account"));
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
}

