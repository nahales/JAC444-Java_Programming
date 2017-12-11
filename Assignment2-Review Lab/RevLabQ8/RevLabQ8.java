package revlabq8;

import java.util.ArrayList;

public class RevLabQ8 {

	public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        System.out.println("\nShuffling list...\n");
        shuffle(list);
        System.out.println(list);

    }

    public static <E> void shuffle(ArrayList<E> list) {

        for (int i = 0; i < list.size(); i++) {
            int random = (int) (Math.random() * list.size());
            E temp = list.get(random);
            list.set(random, list.get(i));
            list.set(i, temp);
        }
    }

}
