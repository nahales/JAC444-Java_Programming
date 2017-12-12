package workshop3q2;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;

public class Workshop3Q2 {
	public static void main(String[] strings) {

		boolean done = false;
        
		do {			
			try {				
				Random random = new Random();
		        int lottery = 100 +  random.nextInt(900);
		        System.out.print("Lottery number: " + lottery + "\n");
		        System.out.print("Enter your three-digit lottery pick: "); 
		        Scanner input = new Scanner(System.in);		        

		        int count = 0;		        
				int guess = input.nextInt();
				 if (guess > 99 && guess < 1000) {
					List<Integer> lotteryList = getDigits(lottery, 3);	
			        List<Integer> guessList = getDigits(guess, 3);
			        if (guess == lottery) {
			        	System.out.println("Exact match: you won $10,000!");
			        } else {
			        
					        for (int i = 0; i < 3; i++) {		        	
					        	for (int j = 0; j < 3; j++) {
					        		if (lotteryList.get(i).equals(guessList.get(j))) {
					        			count++;
					        			break;
					        		}		        		
					        	}
					        }
					        if (count == 3) {
					        	System.out.println("Match 3 digits: you won $3,000");
					        } else if (count == 2) {
					        	System.out.println("Match 2 digits: you won $2,000");
					        } else if (count == 1) {
					        	System.out.println("Match 1 digit: you won $1,000");
					        } else {
					        	System.out.println("Sorry, no match!");
					        }
			        }
			        
				 } else {
					 System.out.println("Ivalid Input!");					 
				 }			 
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input!");
			}
			
			System.out.println("Do you want to try another lottery? (y/n): ");
	        Scanner reInput = new Scanner(System.in);
	        String answerContinue = reInput.nextLine().trim().toLowerCase();
	        if (answerContinue.equals("n")) {
	        	done = true;
	        	System.out.println("Exiting from lottery program .....");
	        }

		} while (!done);		
    }
	
	
	public static ArrayList<Integer> getDigits(int number, int digitCount) {     
        ArrayList<Integer> list = new ArrayList<>(digitCount);
        while (number > 0) {
            list.add(number % 10);
            number /= 10;
        }
        return list;
    }	
}























