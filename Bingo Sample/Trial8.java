import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Trial8 implements ActionListener {   // Try using a HASH MAP for the buttons                   # TEST SUCCESS #
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
    private static Random randomNum = new Random();
    ArrayList<Integer> cardValues = new ArrayList<>();  // list of possible values to be added to the MAIN CARD
    HashMap<Integer, Integer> buttonsMap = new HashMap<Integer, Integer>();

    ArrayList<Integer> bingoValues = new ArrayList<Integer>(); // EDIT

    private int balls = 35;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Constructor
    public Trial8() {
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
                    numberButtons[iter] = new JButton("X"); // middle button will be X
                    numberButtons[iter].setEnabled(false);

                    buttonsMap.put(iter, 0);           // middle number is zero
                }
                else {
                    numberButtons[iter] = new JButton(Integer.toString(card[row][column]));     // assigns random numbers for every button

                    buttonsMap.put(iter, card[row][column]);   // put those random numbers into a hashmap that corresponds to their button number
                }
                iter++;
            }
        }

        System.out.println(buttonsMap); // EDIT
        fillBingoList(bingoValues); // EDIT

        System.out.println(bingoValues);    // EDIT
        
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
        ballLabel.setText("No. of balls left: 35");  // 35 balls will be drawn in 1 round
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

        // return bingoNumber, find the bingoNumber in the HashMap Values, if yes, disable the button key with that value
        int bingoNum = generateNumber(bingoValues);

        bingoLabel.setText("BINGO Number: " + displayBall(bingoNum) + " " + bingoNum);

        displayBall(bingoNum);

        for (int key : buttonsMap.keySet()) {       // checks the HashMap if a Value is the same with the Bingo Number
            if (bingoNum == buttonsMap.get(key)) {
                numberButtons[key].setEnabled(false);
                numberButtons[key].setText("X");
                buttonsMap.put(key, 0);
            }
        }

        System.out.println(buttonsMap);


        if (balls == 0) {                       // PRACTICE
            System.out.println("YES");
        }
    }

    public String displayBall(int bingoNum) {
        String letter = "";
        if (bingoNum > 0 && bingoNum <= 15) {
            letter = "B";
        }
        else if (bingoNum > 15 && bingoNum <= 30) {
            letter = "I";
        }
        else if (bingoNum > 30 && bingoNum <= 45) {
            letter = "N";
        }
        else if (bingoNum > 45 && bingoNum <= 60) {
            letter = "G";
        }
        else if (bingoNum > 60 && bingoNum <= 75) {
            letter = "O";
        }
        return letter;
    }

    public static int generateNumber(ArrayList<Integer> bingoValues) {
        
        System.out.println(bingoValues.size());
        int numIdx = randomNum.nextInt(bingoValues.size());   // randomNum picks and index from 0 to ccurrent size of ArrayList, which denotes the index of the random number
        int randNum = bingoValues.get(numIdx);                // assigns the value at index to randNum, which is our Random Number to be used

        System.out.println("BINGO Number: " + " " + randNum + " at index " + numIdx);

        for (int i = 0; i < bingoValues.size(); i++) {
            if (bingoValues.get(i) == randNum) {
                bingoValues.remove(i);
            }
        }
        
        System.out.println(bingoValues);

        return randNum;
    }

    private void fillBingoList(ArrayList<Integer> bingoValues) {
        for (int i = 1; i < 76; i++) {
            bingoValues.add(i);
        }
        //System.out.println(bingoValues);
    }

    private void fillArrayList(ArrayList<Integer> cardValues, int start) {   // fills values for every column (for B is 1-15, I is 16-30, and so on...)
        cardValues.clear(); // clears the ArrayList, ready to be added new values everytime this function is called

        for (int i = start; i < (start + 15); i++) {    // i starts from 1, 16, 31, 46, 61
            cardValues.add(i);
        }
    }

    

    public static void main(String[] args) {
        new Trial8();

        //Trial8 myObj = new Trial8();    // PRACTICE

        //myObj.generateNumber();         // PRACTICE
    }



    
}




// In this trial, the following are the accomplished tasks:
// > Use HashMap for buttons
// > When DRAW button is clicked:
// >>> The number of balls will decrement.
// >>> The BINGO Number will show, along with its corresponding letter.
// >>> The button with the same value as the BINGO Number will be overwritten as X, and the button will be disabled.

// TO DO:
// > BINGO Patterns
// > Pop-up message after all balls were used (BINGO or Lose)
// > Include Pattern Label, and randomize pattern Button