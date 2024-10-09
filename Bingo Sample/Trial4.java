import java.util.Random;

public class Trial4 {       // Generate Random number
    public static void main(String[] args) {    // generates random number for every letter in BINGO
        Random rand = new Random();

        int[] upperBounds = {15, 30, 45, 60, 75};

        int rand1;

        for (int i = 0; i < 5; i++) {
            int lowerBound = upperBounds[i] - 14;
            rand1 = rand.nextInt(upperBounds[i] - lowerBound) + lowerBound; // picks random number from 0 - 14, then adds lower limit to belong to the limit

            System.out.println(rand1);
        }



    }

}