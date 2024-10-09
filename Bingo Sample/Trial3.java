import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

public class Trial3 {   // MAIN
    JFrame frame;
    JPanel panel, panel2;
    JButton[] button = new JButton[25];
    JLabel[] label = new JLabel[5];
    JLabel bingoLabel, ballLabel;
    JButton button2;

    Font myFont = new Font("Calibri", Font.BOLD, 40);
    Font myFont2 = new Font("Calibri", Font.PLAIN, 29);
    Font myFont3 = new Font("Calibri", Font.PLAIN, 15);

    public Trial3() {   // Constructor
        frame = new JFrame("BINGO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 520);
        frame.setLayout(null);

        String[] bingo = {"B", "I", "N", "G", "O"};

        for (int i = 0; i < 5; i++) {       // Adds the BINGO letters into an array
            label[i] = new JLabel(bingo[i]);
            label[i].setHorizontalAlignment(JLabel.CENTER);
            label[i].setFont(myFont);
        }

        // Subject for change: numbers should be Random
        int irer = 7;
        for (int i = 0; i < 25; i++) {      // Adds the BINGO numbers into an array of buttons
            button[i] = new JButton(Integer.toString(irer));
        }

        panel = new JPanel();
        panel.setBounds(50, 50, 300, 300);
        panel.setLayout(new GridLayout(6, 5, 5, 5));
        //panel.setBackground(Color.GRAY);

        for (int i = 0; i < 30; i++) {
            if (i < 5) {
                panel.add(label[i]);
            }
            else {
                panel.add(button[i - 5]);
            }
        }
        
        bingoLabel = new JLabel();
        bingoLabel.setText("Bingo Number:");
        bingoLabel.setFont(myFont2);
        bingoLabel.setBounds(50, 350, 300, 50);
        /* bingoLabel.setBackground(Color.GRAY);
        bingoLabel.setOpaque(true); */

        button2 = new JButton("DRAW");
        button2.setBounds(233, 400, 117, 45);

        ballLabel = new JLabel();
        ballLabel.setText("No. of balls left: 30");  // 30 balls will be drawn in 1 round
        ballLabel.setFont(myFont3);
        ballLabel.setBounds(233, 445, 117, 30);

        
        frame.add(panel);
        frame.add(bingoLabel);
        frame.add(button2);
        frame.add(ballLabel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Trial3();
    }
}




// NOTES:
// After each round, a new JFrame will pop out with a message either YOU LOSE or BINGO, then will have 2 buttons if the user wants to PLAY AGAIN or QUIT.
// In PLAY AGAIN, the Singleton Pattern may be used here.