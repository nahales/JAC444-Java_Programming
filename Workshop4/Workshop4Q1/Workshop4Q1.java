package workshop4q1;

import java.io.*;
import java.util.*;

public class Workshop4Q1 {
	
	public static void main(String[] args) throws Exception {
		boolean done = false;
		do {
			Scanner input = new Scanner(System.in);
	        System.out.print("Enter a Java source file path: ");     
	        File sourceFile = new File(input.nextLine());
			
	        try {
				System.out.println("The number of keywords in " + sourceFile.getName()
    			+ " is " + countKeywords(sourceFile));
			} catch (FileNotFoundException ex) {
				System.out.println("File '" + sourceFile.getName() + "' does not exist!");
			}
			
			System.out.println("Do you want to try another file? (y/n): ");
	        Scanner reInput = new Scanner(System.in);
	        String answerContinue = reInput.nextLine().trim().toLowerCase();
	        if (answerContinue.equals("n")) {
	        	done = true;
	        	System.out.println("Exiting .....");
	        }
		} while(!done);		
	}
	
    private static boolean[] states = new boolean[4];
    private static int blockComment = 0;
    private static int lineComment = 1;
    private static int stringComment = 2;
    private static int charComment = 3;
    
    public static int countKeywords(File file) throws Exception {

        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};

        Scanner input = new Scanner(file);
        int count = 0;
        HashSet<String> keywords = new HashSet<>(Arrays.asList(keywordString));
        String word = "";
        while (input.hasNext()) {
            word += input.nextLine() + "\n";
        }

        int index;
        while ((index = getNextState(word)) != -1) {
            if (states[blockComment])
                word = removeBlock(word, index);
            else if (states[lineComment])
                word = removeLine(word, index);
            else if (states[stringComment])
                word = removeString(word, index);
            else if (states[charComment])
                word = removeChar(word, index);
        }

        String[] filter = word.split("\\W");

        for (String s : filter) {
            if (s.length() > 0 && keywords.contains(s))
                count++;

        }
        input.close();
        return count;
    }

    private static String removeString(String word, int index) {

        states[stringComment] = false;
        String clean = word.substring(0, index);
        String dirty = word.substring(index + 1);
        int escape = dirty.indexOf("\\");
        int dQuote = dirty.indexOf("\"");
        if (escape == -1 || escape > dQuote) 
            return clean + dirty.substring(dQuote + 1);

        // else get the next double quote that doesn't have an escape character
        Stack<Character> tokens = new Stack<>();

        char[] charArray = dirty.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (ch == '\"' && tokens.isEmpty())
                return clean + dirty.substring(i + 1);

            if (!tokens.isEmpty())
                tokens.pop();
            else if (ch == '\\') {
                tokens.push(ch);
            }
        }
        return "Error finding end of string!";
    }

    private static String removeLine(String word, int index) {
        states[lineComment] = false;
        String clean = word.substring(0, index);
        String end = word.substring(index);
        end = end.substring(end.indexOf("\n"));

        return clean + end;
    }

    private static String removeChar(String word, int index) {
        states[charComment] = false;
        String clean = word.substring(0, index);
        String dirty = word.substring(index + 1);

        if (dirty.charAt(0) == '\\')
            dirty = dirty.substring(3);
        else
            dirty = dirty.substring(2);

        return clean + dirty;
    }

    private static String removeBlock(String s, int index) {
        states[blockComment] = false;
        int end = s.indexOf("*/");
        String clean = s.substring(0, index);
        String endString = s.substring(end + 2);
        return clean + endString;
    }

    public static int getNextState(String s) {

        int[] indices = new int[4];
        String[] startStateTokens = {"/*", "//", "\"", "\'"};

        int lowest = -1;
        int key = 0;
        for (int i = 0; i < indices.length; i++) {
            indices[i] = s.indexOf(startStateTokens[i]);
            if (lowest == -1) {
                lowest = indices[i];
                key = i;
            } else if (lowest > indices[i] && indices[i] >= 0) {
                lowest = indices[i];
                key = i;
            }
        }

        if (key != -1) {
            states[key] = true;
        }

        return indices[key];
    }
}


