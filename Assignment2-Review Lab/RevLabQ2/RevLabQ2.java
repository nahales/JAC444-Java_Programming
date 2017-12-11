import java.util.Date;
import java.text.SimpleDateFormat;

public class RevLabQ2 {

	public static void main(String[] args) {
		// Test program
		Account account = new Account(1122, 20000);
		account.setAnnualInterestRate(4.5);
		account.withdraw(2500);
		account.deposit(3000);
		System.out.println("Balance: $" + account.getBalance());
		System.out.println("Monthly Interest: " + account.getMonthlyInterest());
		System.out.println("Date Created: " + account.getDateCreated());
	}

}


class Account {
	private int id = 0;
	private double balance = 0.0;
	private double annualInterestRate = 0.0;
	private Date dateCreated = new Date();
	
	public Account() {
		this.dateCreated = new Date();
	}
	
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
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
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
}




















