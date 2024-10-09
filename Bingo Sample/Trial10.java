import java.util.HashMap;

public class Trial10 {  // Practice For Each loop

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();


        for (int i = 0; i < 10; i++) {
            map.put(i, i + 5);
        }
    
        // Print values only
    
        int find = 8;
        for (int number : map.values()) {
            if (number == find) {
                System.out.println("FOUND");
            }
            else {
                System.out.println("NOT FOUND");
            }
        }
    }

    
}