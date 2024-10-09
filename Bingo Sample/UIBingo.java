import java.util.List;
import java.util.Scanner;

public class UIBingo {
    int n_cards;
    LogicBingo logic_bingo;
    Scanner scan;

    void displayCards(List<String[][]> cards){
        for(String[][] card:cards) {
            System.out.println("B\tI\tN\tG\tO");
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.print(card[k][j] + "\t");
                }
                System.out.println();
            }
            System.out.println("\n");
        }
    }

    void startGame(int mode)
    {
        String[] header = {"B", "I", "N", "G", "O"};
        for (int i = 0; i<25; i++)
        {
            String number = logic_bingo.numberGenerator(1,74,logic_bingo.bingonumbers);
            System.out.println("\nNumber Drawn: "+header[Math.abs(Integer.parseInt(number)/15)]+number+"\n");
            logic_bingo.checknumber(number);
            displayCards(logic_bingo.cards);
            System.out.println("Do you want to draw another number?(y/n)");
            String choice = scan.next();
            if (choice.toLowerCase().equals("n"))
            {
                displayCards(logic_bingo.cards);
                System.out.println("Thank you for playing!");
                return;
            }
        }
        if (logic_bingo.checkBingo(mode))
        {
            System.out.println("Player x got Bingo!!");
            System.out.println("Here's the winning card!");
            displayCards(logic_bingo.cards);
        }
        else{
            System.out.println("Thank you for playing!");
        }
    }

    public static void main(String args[])
    {
        UIBingo ui_bingo = new UIBingo();
        ui_bingo.logic_bingo = new LogicBingo();

        ui_bingo.scan = new Scanner(System.in);
        System.out.println("How many cards you want to generate?");
        ui_bingo.n_cards = ui_bingo.scan.nextInt();

        ui_bingo.logic_bingo.cardGenerator(ui_bingo.n_cards);
        System.out.println("Your cards have been generated!");

        System.out.println("\nSelect the type of game you want to play:\n1.Full Card Game\n2.Diagonal Bingo\n3.4 Corners");
        int mode = ui_bingo.scan.nextInt();
        ui_bingo.startGame(mode);


    }
}