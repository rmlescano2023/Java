import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BingoResult implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton playButton, quitButton;

    public BingoResult() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 150);
        frame.setLayout(null);

        playButton = new JButton("PLAY AGAIN");
        playButton.setBounds(120, 60, 102, 40);
        playButton.addActionListener(this);

        quitButton = new JButton("QUIT");
        quitButton.setBounds(10, 60, 102, 40);

        frame.add(quitButton);
        frame.add(playButton);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Trial15 mainObj = new Trial15();

        mainObj.closeFrame();
        
        //new Trial15();

        frame.dispose();
        
        
    }

    public static void main(String[] args) {
        new BingoResult();
    }

}
