import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;


public class FinalProject implements ActionListener {

    private int count = 0;
    private JFrame frame;   // initialize these objects
    private JPanel panel;
    private JLabel label;
    
    public FinalProject() {     // Constructor
        frame = new JFrame();   // creates the window

        panel = new JPanel();   // creates layout so yoou can add objects inside the window

        JButton button = new JButton("Click Me");   // Text inside the button is "Click Me"
        button.addActionListener(this);

        label = new JLabel("Number of clicks: 00");


        // these actions below adds objects to the layout
        panel.setBorder(BorderFactory.createEmptyBorder(300, 500, 300, 500));   // creates dimensions of the window (top, bottom, left,  right) -  parameters
        panel.setLayout(new GridLayout(5, 5));  // GridLayout(int rows, int columns, int hgap, int vgap)
        panel.add(label);

        
        frame.add(panel, BorderLayout.CENTER);  // adds the panel to the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // action when the user closes the frame
        frame.setTitle("Our GUI");  // Title of the window
        frame.pack();   // sets the window to match a certain size, in panel.setBorder()
        frame.setVisible(true); // sets window to be visible and in focus
    }

    public static void main(String[] args) {
        new FinalProject();
    }

    @Override
    public void actionPerformed(ActionEvent e) {    // Tied to the button object "button"
        count += 10;
        label.setText("Number of clicks: " + count);
    }

}