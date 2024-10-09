import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicBingo {
    Random rand;
    String[] bingonumbers = new String[25];
    List<String[][]> cards = new ArrayList<>();
    LogicBingo()
    {
        rand = new Random();
    }

    boolean checkDuplicate(String col[], String number){
        for (String i : col) {
            if (i!= null && i.equals(number)) {
                    return true;
            }
        }
        return false;
    }

    List<String[][]> cardGenerator(int n_cards){
        int[] bounds = {1,16,31,46,61};
        for(int i = 0;i< n_cards;i++)
        {
            String[][] card = new String[5][5];

            for(int j=0; j<5;j++)
            {
                int lower_bound = bounds[j];
                for(int k=0; k<5; k++)
                {
                    if(j==2 && k==2){
                        card[j][k] = "0";
                        continue;
                    }
                    card[j][k] = numberGenerator(lower_bound, 14, card[j]);
                }
            }
            cards.add(card);
        }
        return cards;
    }

    String numberGenerator(int lower_bound, int rand_bound, String[] arr)
    {
        String number;
        do{
            number = String.valueOf(rand.nextInt(rand_bound)+lower_bound);
        }while (checkDuplicate(arr, number));
        arr[arr.length-1] = number;
        return number;
    }

    void checknumber(String number){
        int position = Math.abs(Integer.parseInt(number)/15);
        for (String[][] card: cards)
        {
            for(int i=0;i<5;i++)
            {
                if (card[position][i].equals(number))
                {
                    card[position][i] = "x";
                    break;
                }
            }
        }
    }

    boolean checkBingo(int mode)
    {
        boolean flag = true;
        List<Integer> cards_to_remove = new ArrayList<>();

        for (int j = 0; j<cards.size(); j++)
        {
            String[][] card = cards.get(j);
            card[3][3] = "x";
            switch (mode)
            {
                case 1:
                    for (String[] col:card)
                    {
                        for(String item:col)
                        {
                            if (!item.equals("x")){
                                flag = false;
                                break;
                            }
                        }
                        if (!flag)
                        {
                            break;
                        }
                    }
                    break;
                case 2:
                    for (int i=0;i<5;i++)
                    {
                        if (!card[i][i].equals("x"))
                        {
                            flag = false;
                            break;
                        }
                    }
                    for (int i=4;i>=0;i--)
                    {
                        if (!card[i][4-i].equals("x"))
                        {
                            flag = false;
                            break;
                        }
                    }
                    break;
                case 3:
                    flag = card[0][4].equals("x") && card[4][0].equals("x") && card[0][0].equals("x") && card[4][4].equals("x");
                    break;
            }
            if (!flag)
            {
                cards_to_remove.add(j);
            }
        }
        for (int i: cards_to_remove)
        {
            cards.remove(i);
        }
        return flag;
    }

}