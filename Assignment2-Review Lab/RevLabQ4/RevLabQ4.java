package revlabq4;

public class RevLabQ4 {

	public static void main(String[] args) {
		// Create Account, SavingsAccount and Checking Account objects
				Account account = new Account(1122, 20000);
				SavingsAccount savings = new SavingsAccount(1133, 20000);
				CheckingAccount checking = new CheckingAccount(1144, 20000);
				// Set annual interest rate of 4.5%
				account.setAnnualInterestRate(4.5);
				savings.setAnnualInterestRate(4.5);
				checking.setAnnualInterestRate(4.5);

				//Withdraw $2,500
				account.withdraw(2500);
				savings.withdraw(2500);
				checking.withdraw(2500);

				// Deposit $3,000
				account.deposit(3000);
				savings.deposit(3000);
				checking.deposit(3000);
				
				//Withdraw $20,600
				savings.withdraw(20600);
				checking.withdraw(20600);

				// Invoke toString methods
				System.out.println(account.toString());
				System.out.println(savings.toString());
				System.out.println(checking.toString());

	}
	
}

class SavingsAccount extends Account{
	String printW = "";
	String printD = "";
	public SavingsAccount(){
		this(0,0);
	}
	
	public SavingsAccount(int ID, double balance){
		super(ID,balance);
	}
	
	public void withdraw(double withdrawAmount){
		double balance = this.getBalance();
		
	// Not allowed to withdraw over balance in Saving Account
		if(withdrawAmount > balance){
			printW ="Insufficient funds to withdraw $" + withdrawAmount + 
								" from Savings Account which cannot be overdrawn!";
		}
		else {
			balance -= withdrawAmount;
			this.setBalance(balance);
			printW ="The amount of $" + withdrawAmount + 
					" was withdrawn from Savings Account!";
		}
	}
	
	public void deposit(double depositAmount) {
		double balance = this.getBalance();
		balance += depositAmount;
		this.setBalance(balance);
		printD ="The amount of $" + depositAmount + 
				" was depositted to Savings Account!";
	}
	
	public String toString() {
	    return "\nSavings Account\n" +
	            "ID: " + getId() +
	            "\nBalance: " + getBalance() +
	            "\ndateCreated: " + getDateCreated() + 
	            "\n" + printW + 
	            "\n" + printD;
	}
	
}

class CheckingAccount extends Account {
	private final double overDraftLimit = 100.0; 
	String printW = "";
	String printD = "";
	public CheckingAccount(){
		this(0,0);
	}
	
	public CheckingAccount(int ID, double balance){
		super(ID,balance);
	}

	public void withdraw(double withdrawAmount){
		double balance = this.getBalance();
	// Checking account has an overdraft limit
		if(withdrawAmount - balance > overDraftLimit){
			printW ="Insufficient funds to withdraw $" + withdrawAmount + 
					" from Checking Account which has $" +
					overDraftLimit + " overdraft limit!";
		}
		else {
			balance -= withdrawAmount;
			this.setBalance(balance);
			printW ="The amount of $" + withdrawAmount + 
					" was withdrawan from Checking Account which has $" + 
					overDraftLimit + " overdraft limit!";
		}
	}
	
	public void deposit(double depositAmount) {
		double balance = this.getBalance();
		balance += depositAmount;
		this.setBalance(balance);
		printD ="The amount of $" + depositAmount + 
				" was depositted to Checking Account!";
	}
	
	public String toString() {
	    return "\nChecking Account\n" +
	            "ID: " + getId() +
	            "\nBalance: " + getBalance() +
	            "\ndateCreated: " + getDateCreated() + 
	            "\n" + printW + 
	            "\n" + printD;
	}
}
