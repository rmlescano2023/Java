import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Random;

public class Trial7 implements ActionListener {   // Test out MAIN: Add the random numbers in the buttons                     # TEST SUCCESS #
    JFrame frame;
    static JPanel panel, panel2;
    static JButton[] numberButtons = new JButton[25];
    static JLabel[] label = new JLabel[5];
    static JLabel bingoLabel, ballLabel;
    static JButton drawButton;

    Font myFont = new Font("Calibri", Font.BOLD, 40);
    Font myFont2 = new Font("Calibri", Font.PLAIN, 28);
    Font myFont3 = new Font("Calibri", Font.PLAIN, 15);

    private static int[][] card = new int[5][5];        // declare a 2D Array for the numbers in the card, with 5 rows and 5 columns; MAIN CARD
    private Random randomNum = new Random();
    ArrayList<Integer> cardValues = new ArrayList<>();  // list of possible values to be added to the MAIN CARD

    private int balls = 30;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Constructor
    public Trial7() {
        frame = new JFrame("BINGO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 500);
        frame.setLayout(null);

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: BINGO Letters
        String[] bingo = {"B", "I", "N", "G", "O"};

        for (int i = 0; i < 5; i++) {       // Adds the BINGO letters into an array
            label[i] = new JLabel(bingo[i]);
            label[i].setHorizontalAlignment(JLabel.CENTER);
            label[i].setFont(myFont);
        }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: BINGO Letters
        


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Generate Random Numbers in Buttons
        int start = 1;
        for (int column = 0; column < card[0].length; column++) {
            fillArrayList(cardValues, start);

            for (int row = 0; row < card.length; row++) {
                int index = randomNum.nextInt(cardValues.size());   // randomNum picks from 0 - 14, which denotes the index of the array
                card[row][column] = cardValues.get(index);          // assigns an item from the given index to the 2D Array
                cardValues.remove(index);                           // removes that item from the list, and also reducing the size of the list, to avoid duplicates
            }
            start += 15;    // assigns the next lower-bound of the next letter in BINGO
        }

        int iter = 0;
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                if (row == 2 && column == 2) {
                    numberButtons[iter] = new JButton("X");
                    numberButtons[iter].setEnabled(false);
                }
                else {
                    numberButtons[iter] = new JButton(Integer.toString(card[row][column]));     // assigns random numbers for every button
                }
                iter++;
            }
        }
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Generate Random Numbers in Buttons



        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Creates a Panel for the BINGO word and the buttons
        panel = new JPanel();
        panel.setBounds(50, 30, 300, 300);
        panel.setLayout(new GridLayout(6, 5, 5, 5));
        //panel.setBackground(Color.GRAY);

        for (int i = 0; i < 30; i++) {
            if (i < 5) {
                panel.add(label[i]);        // first row is for the BINGO letters
            }
            else {
                panel.add(numberButtons[i - 5]);   // next rows are for the buttons
            }
        }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Creates a Panel for the BINGO word and the buttons



        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Editable label that shows the BINGO Number
        bingoLabel = new JLabel();
        bingoLabel.setText("BINGO Number:");
        bingoLabel.setFont(myFont2);
        bingoLabel.setBounds(50, 330, 300, 50);
        /* bingoLabel.setBackground(Color.GRAY);
        bingoLabel.setOpaque(true); */
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Editable label that shows the BINGO Number



        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Button that draws a number, and decrements the number of balls left
        drawButton = new JButton("DRAW");
        drawButton.setBounds(233, 380, 117, 45);
        drawButton.addActionListener(this);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Button that draws a number, and decrements the number of balls left



        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Editable label that shows the number of balls left
        ballLabel = new JLabel();
        ballLabel.setText("No. of balls left: 30");  // 30 balls will be drawn in 1 round
        ballLabel.setFont(myFont3);
        ballLabel.setBounds(233, 425, 116, 30);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Editable label that shows the number of balls left
        


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Final addition of objects to the aplication window (frame)
        frame.add(panel);
        frame.add(bingoLabel);
        frame.add(drawButton);
        frame.add(ballLabel);
        frame.setVisible(true);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Final addition of objects to the aplication window (frame)


    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Constructor


    @Override
    public void actionPerformed(ActionEvent e) {
        balls--;
        ballLabel.setText("No. of balls left: " + balls);

        bingoLabel.setText("BINGO Number: ");
    }

    private void fillArrayList(ArrayList<Integer> cardValues, int start) {   // fills values for every column (for B is 1-15, I is 16-30, and so on...)
        cardValues.clear(); // clears the ArrayList, ready to be added new values everytime this function is called

        for (int i = start; i < (start + 15); i++) {    // i starts from 1, 16, 31, 46, 61
            cardValues.add(i);
        }
    }

    

    public static void main(String[] args) {
        new Trial7();

    }



    
}




// NOTES:
// After each round, a new JFrame will pop out with a message either YOU LOSE or BINGO, then will have 2 buttons if the user wants to PLAY AGAIN or QUIT.
// In PLAY AGAIN, the Singleton Pattern may be used here.