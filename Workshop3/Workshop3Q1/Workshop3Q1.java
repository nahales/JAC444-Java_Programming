package workshop3q1;

import java.io.*;
import java.util.*;


public class Workshop3Q1 {

    public static void main(String[] args) {
    	boolean done = false;
        do {
	    	Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the text file's name: ");
	        File textFile = new File(scanner.next());
	        
	        String[] words;
	        
	        try (BufferedReader in = new BufferedReader(new FileReader(textFile))) {
	
	            StringBuilder buffer = new StringBuilder(10000);
	            String text;
	         // Set text in a string
	            while ((text = in.readLine()) != null)
	                buffer.append(text).append("\n");
	
	            words = buffer.toString().split("[ \\n\\t\\r.,;:!?(){}]");        
	
	        // Create a TreeMap to hold words as key and count as value
	        Map<String, Integer> map = new TreeMap<>();
	
	        for (int i = 0; i < words.length; i++) {
	        	String key = words[i].toLowerCase();
	        	if (key.length() > 0) {
		        	if (!map.containsKey(key)) {
		        	map.put(key, 1);
		        	}
		        	else {
		        	int value = map.get(key);
		        	value++;
		        	map.put(key, value);
		        	}
	        	}
	        }
	        // Get key and value from each entry
	        map.forEach((k, v) -> System.out.println(k + "\t" + v));
	        
	        } catch (IOException ex) {
	            words = new String[1];
	            System.out.println("Error opening file...");
	
	        }
	        System.out.println("Do you want to try another file? (y/n): ");
	        Scanner reInput = new Scanner(System.in);
	        String answerContinue = reInput.nextLine().trim().toLowerCase();
	        if (answerContinue.equals("n")) {
	        	done = true;
	        	System.out.println("Exiting .....");
	        }
        
        }  while (!done);
        
    }

}
