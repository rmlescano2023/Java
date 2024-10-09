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

public class Trial11 implements ActionListener {   // Accomplish TO DO from Trial8
    JFrame frame;
    static JPanel panel, panel2;
    static JButton[] numberButtons = new JButton[25];
    static JLabel[] label = new JLabel[5];  // BINGO Letters
    static JLabel patternLabel, bingoLabel, ballLabel;
    static JButton drawButton;

    Font myFont = new Font("Calibri", Font.BOLD, 40);
    Font myFont2 = new Font("Calibri", Font.PLAIN, 28);
    Font myFont3 = new Font("Calibri", Font.PLAIN, 15);

    private static int[][] card = new int[5][5];        // declare a 2D Array for the numbers in the card, with 5 rows and 5 columns; MAIN CARD
    private static Random randomNum = new Random();
    ArrayList<Integer> cardValues = new ArrayList<Integer>();  // list of possible values to be added to the MAIN CARD
    HashMap<Integer, Integer> buttonsMap = new HashMap<Integer, Integer>();

    ArrayList<Integer> bingoValues = new ArrayList<Integer>(); // EDIT

    private int balls = 75;
    private int choosePattern = 0;  // indicator if pattern has been chosen, sets to 1 if done
    private int pattern;    // determines what pattern to be used, 0 = Four Corners, 1 = Straight Across, 2 = Straight Down

    int fourCorners, straightDown, straightAcross;
    Boolean bool;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Constructor
    public Trial11() {
        frame = new JFrame("BINGO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 545);
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



        System.out.println("HashMap: " + buttonsMap); // EDIT

        fillBingoList(bingoValues); // EDIT

        System.out.println("Bingo Values: " + bingoValues);    // EDIT
        
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



        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Creates a Label for the Pattern that will be used
        patternLabel = new JLabel();
        patternLabel.setText("Pattern: ");
        patternLabel.setFont(myFont2);
        patternLabel.setBounds(50, 335, 300, 50);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Creates a Label for the Pattern that will be used


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Editable label that shows the BINGO Number
        bingoLabel = new JLabel();
        bingoLabel.setText("BINGO Number:");
        bingoLabel.setFont(myFont2);
        bingoLabel.setBounds(50, 375, 300, 50);
        /* bingoLabel.setBackground(Color.GRAY);
        bingoLabel.setOpaque(true); */
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Editable label that shows the BINGO Number



        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Button that draws a number, and decrements the number of balls left
        drawButton = new JButton("DRAW");
        drawButton.setBounds(233, 425, 117, 45);
        drawButton.addActionListener(this);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Button that draws a number, and decrements the number of balls left



        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Editable label that shows the number of balls left
        ballLabel = new JLabel();
        ballLabel.setText("No. of balls left: 75");  // 35 balls will be drawn in 1 round
        ballLabel.setFont(myFont3);
        ballLabel.setBounds(233, 470, 116, 30);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Editable label that shows the number of balls left
        


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Final addition of objects to the aplication window (frame)
        frame.add(panel);
        frame.add(patternLabel);
        frame.add(bingoLabel);
        frame.add(drawButton);
        frame.add(ballLabel);
        frame.setVisible(true);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Final addition of objects to the aplication window (frame)


    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Constructor


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Actions when DRAW Button is clicked

    @Override
    public void actionPerformed(ActionEvent e) {
        balls--;
        ballLabel.setText("No. of balls left: " + balls);

        // return bingoNumber, find the bingoNumber in the HashMap Values, if yes, disable the button key with that value
        int bingoNum = generateNumber(bingoValues);

        bingoLabel.setText("BINGO Number: " + displayBall(bingoNum) + " " + bingoNum);

        if (choosePattern == 0) {
            pattern = randomizePattern();

            switch(pattern) {
                case 0: patternLabel.setText("Pattern: Four Corners");      break;
                case 1: patternLabel.setText("Pattern: Straight Across");   break;
                case 2: patternLabel.setText("Pattern: Straight Down");     break;
            }
            choosePattern = 1;
        }

        displayBall(bingoNum);

        for (int key : buttonsMap.keySet()) {       // checks the HashMap if a Value is the same with the Bingo Number
            if (bingoNum == buttonsMap.get(key)) {
                numberButtons[key].setEnabled(false);
                numberButtons[key].setText("X");
                buttonsMap.put(key, 0);
            }
        }

        System.out.println(buttonsMap);
        System.out.println("Pattern is: " + pattern);

        Boolean check = checkCard(pattern);

        if (check == true) {   // meaning the given pattern was accomplished, BINGO!
            System.out.println("BINGO!");
        }

        if (balls == 0) {                       // PRACTICE
            System.out.println("YES");
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Actions when DRAW Button is clicked



    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Checks if pattern is accomplished
    public boolean checkCard(int pattern) {

        int rowCount = 0;

        bool = false;

        if (pattern == 0) {     // Four Corners pattern
            fourCorners = buttonsMap.get(0) + buttonsMap.get(4) + buttonsMap.get(20) + buttonsMap.get(24);

            if (fourCorners == 0) {
                bool = true;
            }
            
        }
        else if (pattern == 1) {                    // Straight Across pattern

            for (int row = 0; row < 5; row++) {     
                straightAcross = 0;

                for (int column = 0; column < 5; column++) {
                    straightAcross += buttonsMap.get(rowCount);
                    rowCount++;
                }
    
                if (straightAcross == 0) {
                    bool = true;
                    break;
                }
                
            }

        }
        else if (pattern == 2) {

            for (int column = 0; column < 5; column++) {    // for Straight Down
                rowCount = column;
                straightDown = 0;

                for (int row = 0; row < 5; row++) {
                    straightDown += buttonsMap.get(rowCount);
                    rowCount += 5;
                }

                if (straightDown == 0) {
                    bool = true;
                    break;
                }
                
            }
        }

        return bool;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Checks if pattern is accomplished



    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Returns the BINGO Letter
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
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Returns the BINGO Letter



    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Generates a pattern to be used during the round
    public int randomizePattern() {    // use Singleton?
        Random random = new Random();
        int randomPattern = random.nextInt(3);

        return randomPattern;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Generates a pattern to be used during the round



    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Generates a Random Number
    public static int generateNumber(ArrayList<Integer> bingoValues) {
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
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Generates a Random Number



    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Fills an ArrayList of the BINGO Numbers to be drawn
    private void fillBingoList(ArrayList<Integer> bingoValues) {
        for (int i = 1; i < 76; i++) {
            bingoValues.add(i);
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Fills an ArrayList of the BINGO Numbers to be drawn



    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Fills an ArrayList of values for every letter in BINGO
    private void fillArrayList(ArrayList<Integer> cardValues, int start) {   // fills values for every column (for B is 1-15, I is 16-30, and so on...)
        cardValues.clear(); // clears the ArrayList, ready to be added new values everytime this function is called

        for (int i = start; i < (start + 15); i++) {    // i starts from 1, 16, 31, 46, 61
            cardValues.add(i);
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Fills an ArrayList of values for every letter in BINGO


    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: MAIN
    public static void main(String[] args) {
        new Trial11();

        //Trial8 myObj = new Trial8();    // PRACTICE

        //myObj.generateNumber();         // PRACTICE
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: MAIN




    
}




// TO DO:
// > BINGO Patterns and Checking [DONE]
// > Pop-up message after all balls were used (BINGO or Lose)
// > Include Pattern Label [DONE], and randomize pattern Button [OMITTED]