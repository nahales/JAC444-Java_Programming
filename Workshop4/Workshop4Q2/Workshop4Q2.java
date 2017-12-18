package workshop4q2;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Workshop4Q2 {

	static final int bankID = 0;
    static final int loan = 1;
    static double[][][] mBanks;
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of banks: ");
        int n = input.nextInt();
        System.out.print("Enter minimum limit: ");
        int limit = input.nextInt(); 
        mBanks = new double[n][][];
        System.out.println("Enter the following information for each bank, in the same order as below:");
        System.out.println("Bank #  > Balance > Number of banks Loaned > 1st Bank ID > Amount > 2nd Bank ID > Amount > ...");
        for (int i = 0; i < mBanks.length; i++) {
            System.out.print("Bank #" + i + " > ");
            double balance = input.nextDouble();
            int numBanks = input.nextInt();
            mBanks[i] = new double[++numBanks][2];
            mBanks[i][0][0] = balance;
            for (int bank = 1; bank < mBanks[i].length; bank++) {
                mBanks[i][bank][bankID] = input.nextInt();
                mBanks[i][bank][loan] = input.nextDouble();
            }
        }

        boolean[] unsafeIndex = new boolean[mBanks.length];
        double [] total = new double[5];
        boolean isSafe = false;
        while (!isSafe) {
            isSafe = true;
            for (int banks = 0; banks < mBanks.length; banks++) {
                total[banks] = mBanks[banks][0][0];
                for (int LoanedBanks = 1; LoanedBanks < mBanks[banks].length; LoanedBanks++) {
                    int index = (int)mBanks[banks][LoanedBanks][bankID];
                    if (!unsafeIndex[index])
                    	total[banks] += mBanks[banks][LoanedBanks][loan];
                }
                if (total[banks] < limit && !unsafeIndex[banks]) {
                	unsafeIndex[banks] = true;
                    isSafe = false;
                }
            }
        }
        
        List<Integer> unsafeArr = new ArrayList<Integer>();
        for (int i = 0; i < unsafeIndex.length; i++) {
        	if (unsafeIndex[i] == true) {
        		unsafeArr.add(i);
        		System.out.println("Bank# " + i + " total assets: $" + total[i] + " --> Unsafe");
        	} else {
        		System.out.println("Bank# " + i + " total assets: $" + total[i] + " --> Safe");
        	}
        }
        
        if (unsafeArr.size() == 0) {
        	System.out.println("All banks are safe");
        } else if (unsafeArr.size() == 1) {
        	System.out.print("The only unsafe bank is Bank " + unsafeArr.get(0));
        }
        else {
            System.out.print("***** Unsafe banks are");
            for (int j = 0; j < unsafeArr.size(); j++) {
            	System.out.print(" Bank " + unsafeArr.get(j));
            	if (j < unsafeArr.size()-1) {
            		System.out.print(" and");
            	}
            }
            System.out.print(" *****");
        }
        
        input.close();
    }
}
