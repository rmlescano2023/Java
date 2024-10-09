import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JButton;

public class Trial14 {

    static JButton[] numberButtons = new JButton[25];

    static ArrayList<Integer> cardValues = new ArrayList<Integer>();    // holds possible values for B (1-15), I (16-30), N (31-45), G (46-60), O (61-75), everytime the functon is called
    static HashMap<Integer, Integer> buttonsMap = new HashMap<Integer, Integer>();
    static Random random = new Random();

    static int[] lowerBounds = {1, 16, 31, 46, 61};

    


    private static void fillArrayList(ArrayList<Integer> cardValues, int start, int end) {   // fills values for every column (for B is 1-15, I is 16-30, and so on...)
        cardValues.clear(); // clears the ArrayList, ready to be added new values everytime this function is called

        for (int i = start; i <= end; i++) {    // i starts from 1, 16, 31, 46, 61
            cardValues.add(i);
        }
    }




    public static void main(String[] args) {

        int count;
        int randomIndex;
        int randomNum;

        for (int i = 0; i < 5; i++) {   // Goal is to fill the HashMap with corresponding values of the BINGO Letters
            fillArrayList(cardValues, lowerBounds[i], lowerBounds[i] + 14);

            System.out.println("Initial Array: " + cardValues);
            
            count = i;
            for (int j = 0; j < 5; j++) {
                System.out.println("Count: " + count);

                if (count == 12) {
                    buttonsMap.put(count, 0);  
                }
                else {
                    randomIndex = random.nextInt(cardValues.size());
                    randomNum = cardValues.get(randomIndex);

                    System.out.println("Removed from the array the random number " + randomNum + " at index " + randomIndex);

                    buttonsMap.put(count, randomNum);
                    cardValues.remove(randomIndex);
                }

                count += 5;

                System.out.println("Current Array: " + cardValues);
                System.out.println("Current HashMap: " + buttonsMap);
                System.out.println();
            }
        }

        // Next, add the Values from the HashMap using its Keys
        for (int i = 0; i < 25; i++) {
            numberButtons[i] = new JButton(Integer.toString(buttonsMap.get(i)));
        }

        

        
    }
}
