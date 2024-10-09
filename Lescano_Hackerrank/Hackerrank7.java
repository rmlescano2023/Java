// Hackerrank 7 - Java Output Formatting

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("================================");
            
            for(int i = 0; i < 3; i++) {
                String s1 = sc.next();
                int x = sc.nextInt();
                
                //Complete this line
                System.out.printf("%-15s%03d\n", s1, x); // EXPLANATION BELOW
            }
            
            System.out.println("================================");

    }
}

// in line 15, printf() method was used, which enables us to print lines in a formatted manner.
// Verbal: The syntax used in this line is only applicable when printf() method is used, where we
//can use formatting methods such as %s and %d. This won't be possible for other methods like print() or println().

// %s - string format, and %d - integer format
// The -15 in %-15s denotes that the program will provide 15 character spaces for something to be printed there.
// Verbal: The negative (-) means that the printed string will be left-aligned, and the number 15 is how many
//character spaces will be provided.

// The 3 in the %03d denotes the character length which is 3 digits, and the zero before it is a fill character.
// Verbal: This means that zeroes will be added to the left of the integer when the integer is only either 1 or 2 digits long.