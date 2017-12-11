package revlabq5;

import java.text.SimpleDateFormat;

public class Transaction {
	
	private java.util.Date date;
	private char type;
	private double amount;
	private double balance;
	private String description;

	public Transaction(char type, double amount, 
		double balance, String description) {
		date = new java.util.Date();
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
	}

	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/yyyy hh:mm:ss");
		String dateStr = sdf.format(date);
		return dateStr;
	}

	public void setType(char type) {
		this.type = type;
	}

	public char getType() {
		return type;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
