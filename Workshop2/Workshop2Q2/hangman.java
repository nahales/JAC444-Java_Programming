package workshop2q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class hangman {

	static ArrayList<String> words = new ArrayList<>();

    static boolean isCorrect;

    public static void main(String[] args) {

        File textFile = new File("hangman.txt");
        if (!textFile.exists()) {
            System.out.println(textFile.getAbsolutePath());
            System.out.println(textFile + " does not exist.");
            System.exit(1);
        }

        try {
            Scanner input = new Scanner(textFile);
            while (input.hasNext()) {
                words.add(input.next());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        Scanner input = new Scanner(System.in);
        String playContinue = "y";
        while (playContinue.equals("y")) {
            String word = getWord();
            String hiddenWord = getHiddenWord(word);
            int count = 0;
            while (!word.equals(hiddenWord)) {

                System.out.print("(Guess) Enter a letter in word " + hiddenWord + " > ");
                char ch = input.next().charAt(0);

                if (!isAlreadyInWord(hiddenWord, ch)) {

                    hiddenWord = getGuess(word, hiddenWord, ch);

                    if (!isCorrect) {
                        System.out.println(ch + " is not in the word.");
                        count++;
                    }

                } else {
                    System.out.println(ch + " is already in word.");
                }

            }
            System.out.println("The word is '" +  hiddenWord + "'. You missed " + count + " time(s).");
            System.out.println("Do you want to guess another word? Enter y or n>");
            playStats = input.next();
        }

    }

    public static String getWord() {
        return words.get((int) (Math.random() * words.size()));
    }

    public static String getHiddenWord(String word) {

        String hidden = "";
        for (int i = 0; i < word.length(); i++) {
            hidden += "*";
        }
        return hidden;
    }

    static public String getGuess(String word, String hiddenWord, char ch) {

        isCorrect = false;
        StringBuilder s = new StringBuilder(hiddenWord);
        for (int i = 0; i < word.length(); i++) {

            if (ch == word.charAt(i) && s.charAt(i) == '*') {
                isCorrect = true;
                s = s.deleteCharAt(i);
                s = s.insert(i, ch);
            }
        }
        return s.toString();
    }

    public static boolean isAlreadyInWord(String hiddenWord, char ch) {

        for (int i = 0; i < hiddenWord.length(); i++) {

            if (ch == hiddenWord.charAt(i)) {
                return true;
            }
        }
        return false;
    }

}
