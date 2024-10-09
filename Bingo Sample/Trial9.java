import java.util.HashMap;
import java.util.Random;

public class Trial9 {       // Practice using a HashMap
    public static void main(String[] args) {
        HashMap<Integer, Integer> buttonsMap = new HashMap<Integer, Integer>();
        Random rand = new Random();

        int rand1;
        for (int i = 0; i < 25; i++) {
            rand1 = rand.nextInt(75); // picks random number from 0 - 14, then adds lower limit to belong to the limit

            buttonsMap.put(i, rand1);
        }

        System.out.println(buttonsMap);
    }
}