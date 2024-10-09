import java.util.ArrayList;


public class Trial {
    static ArrayList<Integer> arr = new ArrayList<Integer>();                   // list of possible values to be added to the MAIN CARD

    public static void main(String[] args) {
        int start = 1, end = 75;

        while (start != end + 1) {
            arr.add(start);
            start++;
        }

        System.out.println(arr);
    }
}