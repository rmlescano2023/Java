import java.util.ArrayList;
import java.util.Random;

public class Trial17 {
    static Random rand = new Random();
    
    static ArrayList<Integer> cardValues = new ArrayList<Integer>();
    static Boolean bool = false;
    static int pattern, start, end;

    public static void main(String[] args) {

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FACTORY PATTERN TRIAL
        GeneratorFactory generate = new GeneratorFactory();

        Fill getCard = generate.fillValues("CARD");
        getCard.fillArrayList(cardValues, 16);
        System.out.println(cardValues);


        Fill getBall = generate.fillValues("BALL");

        getBall.fillArrayList(cardValues, 1);

        System.out.println(cardValues);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FACTORY PATTERN TRIAL








        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ STRATEGY PATTERN TRIAL
        pattern = rand.nextInt(3);
        System.out.println("Pattern: " + pattern);

        CheckContext checkCard;

        switch(pattern) {
            case 0:
                checkCard = new CheckContext(new FourCorners());
                checkCard.executeCheck();
                break;
            case 1:
                checkCard = new CheckContext(new StraightAcross());
                System.out.println(checkCard.executeCheck());
                break;
            case 2:
                checkCard = new CheckContext(new StraightDown());
                System.out.println(checkCard.executeCheck());
                break;
        }
        //choosePattern = 1;
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ STRATEGY PATTERN TRIAL








        
    }
}