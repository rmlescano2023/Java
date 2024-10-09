import java.util.ArrayList;
import java.util.Random;

public class Trial2 {
    private static int[][] card = new int[5][5];   // declare a 2D Array for the numbers in the card, with 5 rows and 5 columns
    private Random randomNum = new Random();

    public Trial2() {   // Constructor
        // Use ArrayList for the numbers so that there will be no duplicate
        ArrayList<Integer> cardValues = new ArrayList<>();

        int start = 1;
        for (int column = 0; column < card[0].length; column++) {
            fillArray(cardValues, start);

            for (int row = 0; row < card.length; row++) {

                int index = randomNum.nextInt(cardValues.size());
                card[row][column] = cardValues.get(index);
                cardValues.remove(index);
            }
            start += 15;
        }
    }

    private void fillArray(ArrayList<Integer> cardValues, int start) {   // fills values for every column (for B is 1-15, I is 16-30, and so on...)
        cardValues.clear();

        for (int i = start; i < (start + 15); i++) {
            cardValues.add(i);
        }
    }

    public static void main(String[] args) {
        new Trial2();

        for (int row = 0; row < 5; row++) {

            for (int column = 0; column < 5; column++) {

                System.out.print(card[row][column] + "\t");

            }
            System.out.println();

        }
    }
}