package revlabq3;

import java.util.Scanner;

public class RevLabQ3 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Account[] accounts = new Account[10];

		// Initializes accounts array objects with default balance
		initialBalance(accounts);
		
		// Outer loop for getting new id
		do {
			System.out.print("Enter an id: ");
			int id = input.nextInt();
			
			//Validates input ID
			if (isValidID(id, accounts)) {
				int choice;
				do {	
					// Displays menu and gets the user's choice
					choice = displayMainMenu(input);
					if (choice >= 1 && choice <= 3) {
							executeTransaction(choice, accounts, id, input);
					}
				} while (choice != 4);
			}
			else {
				System.out.println("Invalid ID. Try again...\n");
			}
		} while (true); 
	}

	// Initializes accounts array objects with default balance
	public static void initialBalance(Account[] acc) {
		int initialBalance = 100;
		for (int i = 0; i < acc.length; i++) {
			acc[i] = new Account(i, initialBalance);
		}
	}

	//Validates input ID
	public static boolean isValidID(int id, Account[] acc) {
		for (int i = 0; i < acc.length; i++) {
			if (id == acc[i].getId())
				return true;
		}
		return false;
	}

	// Displays menu
	public static int displayMainMenu(Scanner input) {
		System.out.print(
						"\nMain menu\n" +
						"1: check balance\n" +
						"2: withdraw \n" +
						"3: deposit\n" +
						"4: exit\n" + 
						"Enter a choice: ");
		return input.nextInt();
	}

	// Executes the requested transaction
	public static void executeTransaction(int ch, Account[] acc, int id, Scanner input) {
		
		switch (ch) {
			case 1: // Displays the current balance
					  System.out.println("The balance is " + acc[id].getBalance());
					  break;
			case 2: // Withdraws the entered amount
					  System.out.print("Enter an amount to withdraw: "); 
					  acc[id].withdraw(input.nextDouble());
					  break;
			case 3: // Deposits the entered amount
					  System.out.print("Enter an amount to deposit: "); 
					  acc[id].deposit(input.nextDouble());
		}
	}
}