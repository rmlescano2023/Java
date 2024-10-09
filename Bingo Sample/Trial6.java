import java.util.ArrayList;

public class Trial6 {       // Practice ArrayList
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i + 1);
        }

        System.out.println(numbers);

        numbers.remove(3);  // The argument referes to the index in the ArrayList

        System.out.println(numbers);

        numbers.remove(3);
        System.out.println(numbers);
    }
}