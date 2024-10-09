public class Trial5 {
    
    public static void main(String[] args) {    // Print numbers Horizontally in a 2D array
        /* int[][] card = {{1, 2}, {3, 4}};

        System.out.println(card[1][1]); */



        int count = 1;
        int[][] card = new int[5][5];

        for (int column = 0; column < 5; column++) {

            for (int row = 0; row < 5; row++) {

                card[column][row] = count;
                count++;

            }

        }

        for (int row = 0; row < 5; row++) {

            for (int column = 0; column < 5; column++) {

                System.out.print(card[column][row] + "\t");

            }
            System.out.println();

        }



    }

}
