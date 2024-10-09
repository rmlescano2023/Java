import java.util.HashMap;

public class Trial12 {      // Modifications for pattern checking               # TRIAL SUCCESS #
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(0, 12);
        map.put(1, 13);
        map.put(2, 14);
        map.put(3, 15);
        map.put(4, 16);
        map.put(5, 17);
        map.put(6, 18);
        map.put(7, 19);
        map.put(8, 20);
        map.put(9, 21);
        map.put(10, 12);
        map.put(11, 13);
        map.put(12, 14);
        map.put(13, 15);
        map.put(14, 16);
        map.put(15, 17);
        map.put(16, 18);
        map.put(17, 19);
        map.put(18, 20);
        map.put(19, 21);
        map.put(20, 17);
        map.put(21, 18);
        map.put(22, 19);
        map.put(23, 20);
        map.put(24, 21);
        

        System.out.println(map);

        map.put(4, 0);
        map.put(9, 0);
        map.put(14, 0);
        map.put(19, 0);
        map.put(24, 0);

        System.out.println(map);

        int rowCount = 0;
        int straightAcross;
        int straightDown;

        for (int column = 0; column < 5; column++) {        // for Straight Down
            rowCount = column;
            straightDown = 0;

            for (int row = 0; row < 5; row++) {
                System.out.println("Key: " + rowCount + " has Value: " + map.get(rowCount));

                straightDown += map.get(rowCount);
                rowCount += 5;
            }

            if (straightDown == 0) {
                System.out.println("BINGO at Column " + column);
                break;
            }
            
        }

        for (int row = 0; row < 2; row++) {                 // Straight Across Pattern
            straightAcross = 0;

            for (int column = 0; column < 5 ; column++) {
                System.out.println("Key: " + rowCount + " has Value: " + map.get(rowCount));

                straightAcross += map.get(rowCount);
                rowCount++;
            }

            if (straightAcross == 0) {
                System.out.println("BINGO at Row " + row);
                break;
            }
            

        }

        


   
    }
}