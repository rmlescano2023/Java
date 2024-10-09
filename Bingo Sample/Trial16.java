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

public class Trial16 implements ActionListener {   // TRIAL: Try OOP
    JFrame frame;
    static JPanel panel, panel2;
    static JButton[] numberButtons = new JButton[25];
    static JLabel[] label = new JLabel[5];                          // BINGO Letters
    static JLabel patternLabel, bingoLabel, ballLabel, resultLabel;
    static JButton drawButton;

    Font myFont = new Font("Calibri", Font.BOLD, 40);
    Font myFont2 = new Font("Calibri", Font.PLAIN, 28);
    Font myFont3 = new Font("Calibri", Font.PLAIN, 15);

    private static Random random = new Random();

    ArrayList<Integer> cardValues = new ArrayList<Integer>();                   // list of possible values to be added to the MAIN CARD
    HashMap<Integer, Integer> buttonsMap = new HashMap<Integer, Integer>();     // HashMap for the buttons and their assigned random number

    private int balls = 35;
    private int choosePattern = 0;      // indicator if pattern has been chosen, sets to 1 if done
    private int pattern;                // determines what pattern to be used, 0 = Four Corners, 1 = Straight Across, 2 = Straight Down

    int fourCorners, straightDown, straightAcross;
    Boolean bool;

    static int[] lowerBounds = {1, 16, 31, 46, 61};
    static int count, randomNum, randomIndex;


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Constructor
    public Trial16() {
        frame = new JFrame("BINGO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 595);
        frame.setLayout(null);


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: BINGO Letters
        String[] bingo = {"B", "I", "N", "G", "O"};

        for (int i = 0; i < 5; i++) {           // Adds the BINGO letters into an array
            label[i] = new JLabel(bingo[i]);
            label[i].setHorizontalAlignment(JLabel.CENTER);
            label[i].setFont(myFont);
        }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: BINGO Letters
        

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Generate Random Numbers in Buttons
        for (int i = 0; i < 5; i++) {   // Goal is to fill the HashMap with corresponding values of the BINGO Letters
            fillArrayList(cardValues, lowerBounds[i], lowerBounds[i] + 14);
            
            count = i;
            for (int j = 0; j < 5; j++) {
                if (count == 12) {
                    buttonsMap.put(count, 0);  
                }
                else {
                    randomIndex = random.nextInt(cardValues.size());
                    randomNum = cardValues.get(randomIndex);

                    buttonsMap.put(count, randomNum);
                    cardValues.remove(randomIndex);
                }
                count += 5;
            }
        }

        // Next, add the Values from the HashMap using its Keys
        for (int i = 0; i < 25; i++) {
            if (i == 12) {
                numberButtons[i] = new JButton("X");
                numberButtons[i].setEnabled(false);
                continue;
            }
            numberButtons[i] = new JButton(Integer.toString(buttonsMap.get(i)));
        }

        // Next, fill an ArrayList from 1-75 for the BINGO Number picker
        fillArrayList(cardValues, 1, 75);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Generate Random Numbers in Buttons


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Creates a Panel for the BINGO word and the buttons
        panel = new JPanel();
        panel.setBounds(50, 30, 300, 300);
        panel.setLayout(new GridLayout(6, 5, 5, 5));

        for (int i = 0; i < 30; i++) {
            if (i < 5) {
                panel.add(label[i]);                // first row is for the BINGO letters
            }
            else {
                panel.add(numberButtons[i - 5]);    // next rows are for the buttons
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
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Editable label that shows the BINGO Number


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Button that draws a number, and decrements the number of balls left
        drawButton = new JButton("DRAW");
        drawButton.setBounds(233, 425, 117, 45);
        drawButton.addActionListener(this);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Button that draws a number, and decrements the number of balls left


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Editable label that shows the number of balls left
        ballLabel = new JLabel();
        ballLabel.setText("No. of balls left: 35");     // 35 balls will be drawn in 1 round
        ballLabel.setFont(myFont3);
        ballLabel.setBounds(233, 470, 116, 30);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Editable label that shows the number of balls left
        

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Editable label that shows the number of balls left
        resultLabel = new JLabel("Thanks for playing!");
        resultLabel.setText("Thanks for playing!");
        resultLabel.setFont(myFont2);
        resultLabel.setBounds(90, 500, 217, 50);
        resultLabel.setVisible(false);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Editable label that shows the number of balls left


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Final addition of objects to the aplication window (frame)
        frame.add(panel);
        frame.add(patternLabel);
        frame.add(bingoLabel);
        frame.add(drawButton);
        frame.add(ballLabel);
        frame.add(resultLabel);
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
        int bingoNum = generateNumber(cardValues);

        bingoLabel.setText("BINGO Number: " + displayBall(bingoNum) + " " + bingoNum);

        if (choosePattern == 0) {           // Shows what pattern will be used for the round
            pattern = randomizePattern();

            switch(pattern) {
                case 0: patternLabel.setText("Pattern: Four Corners");      break;
                case 1: patternLabel.setText("Pattern: Straight Across");   break;
                case 2: patternLabel.setText("Pattern: Straight Down");     break;
            }
            choosePattern = 1;
        }

        for (int key : buttonsMap.keySet()) {       // checks the HashMap if a Value is the same with the Bingo Number
            if (bingoNum == buttonsMap.get(key)) {
                numberButtons[key].setEnabled(false);
                numberButtons[key].setText("X");
                buttonsMap.put(key, 0);
            }
        }


        if (checkCard(pattern) == true) {   // meaning the given pattern was accomplished, BINGO!
            drawButton.setEnabled(false);

            resultLabel.setText("BINGO! YOU WIN!");
            resultLabel.setVisible(true);
        }
        else if (balls == 0) {
            drawButton.setEnabled(false);

            resultLabel.setVisible(true);
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Actions when DRAW Button is clicked

    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Generates a Random Number
    public static int generateNumber(ArrayList<Integer> cardValues) {       // Include in Facade Pattern
        int numIdx = random.nextInt(cardValues.size());     // randomNum picks and index from 0 to ccurrent size of ArrayList, which denotes the index of the random number
        int randNum = cardValues.get(numIdx);               // assigns the value at index to randNum, which is our Random Number to be used

        for (int i = 0; i < cardValues.size(); i++) {
            if (cardValues.get(i) == randNum) {
                cardValues.remove(i);
            }
        }
        
        return randNum;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Generates a Random Number


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Checks if pattern is accomplished
    public boolean checkCard(int pattern) {     // Included in Strategy Pattern
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
    public String displayBall(int bingoNum) {       // Include in Facade Pattern
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
    public int randomizePattern() {         // Include in Facade Pattern
        Random random = new Random();
        int randomPattern = random.nextInt(3);

        return randomPattern;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Generates a pattern to be used during the round


    // Included in Factory Pattern
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: Fills an ArrayList of values for every letter in BINGO
    private static void fillArrayList(ArrayList<Integer> cardValues, int start, int end) {   // fills values for every column (for B is 1-15, I is 16-30, and so on...)
        cardValues.clear();         // clears the ArrayList, ready to be added new values everytime this function is called

        for (int i = start; i <= end; i++) {    // i starts from 1, 16, 31, 46, 61
            cardValues.add(i);
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: Fills an ArrayList of values for every letter in BINGO

    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START: MAIN
    public static void main(String[] args) {
        Trial16 mainObj = new Trial16();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END: MAIN
}