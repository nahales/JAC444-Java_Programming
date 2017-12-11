package revlabq7;

import java.util.ArrayList;

public class RevLabQ7 {
	
	public static void main(String[] args) {

        ArrayList<Number> list = new ArrayList<>();
        for (int i = 0; i <= 30; i++) list.add(i);

        System.out.println(list);
        System.out.println("\nShuffling list...\n");
        shuffle(list);
        System.out.println(list);
    }

    public static void shuffle(ArrayList<Number> list) {
        // manual shuffle
        for (int i = 0; i < list.size(); i++) {
            int randomIndex = (int) (Math.random() * list.size());
            Number temp = list.get(randomIndex);
            list.set(randomIndex, list.get(i));
            list.set(i, temp);
        }

    }
}
