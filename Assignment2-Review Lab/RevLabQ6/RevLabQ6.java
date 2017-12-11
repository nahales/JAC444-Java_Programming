package revlabq6;

import java.util.Scanner;
import java.util.ArrayList;

public class RevLabQ6 {

	public static void main(String[] args) {

        System.out.print("Enter 10 integers: ");
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(input.nextInt());
        
        removeDuplicate(list);
        
        System.out.println("The distinct integers are: ");
        for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
    }

    public static void removeDuplicate(ArrayList<Integer> list) {

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            if (!temp.contains(list.get(i))) {
                temp.add(list.get(i));
            }
        }
        list.clear();
        list.addAll(temp);

    }
}
