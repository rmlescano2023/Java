// Hackerrank 3 - Java Datatypes

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String  []argh) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0;i<t;i++)
        {
            try
            {
                long x=sc.nextLong();
                System.out.println(x + " can be fitted in:");
                
                if (x >= -128 && x <= 127) System.out.println("* byte");
                //Complete the code
                if (x >= (-(Math.pow(2,15))) && x <= (Math.pow(2,15)-1)) System.out.println("* short");
                if (x >= (-(Math.pow(2,31))) && x <= (Math.pow(2,31)-1)) System.out.println("* int");
                if (x >= (-(Math.pow(2,63))) && x <= (Math.pow(2,63)-1)) System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}
// Verbal Explanation:
// We used the Java Math class in this case because we are dealing with ranges that are in very large numbers. This also makes the code look optimized and clean,
// rather than typing-in really long numbers in the code.
// We also forced using multiple if-statements because a certain numbers are true to different conditions. Using else-if's will only make the numbers
// pass through whichever condition that came first that made it true,
// and will then skip the other conditions and proceed to the end of the codeblock. So, that's why multiple if statements were used instead.

// Ranges of the ff. data types:
// For short: -(Math.pow(2,15)) = -32,768 and Math.pow(2,15)-1 = 32,767
// For int: -(Math.pow(2,31) = -2,147,483,648 and Math.pow(2,31)-1 = -2,147,483,647
// For long: -(Math.pow(2,63) = –9,223,372,036,854,775,808 and Math.pow(2,63)-1 = –9,223,372,036,854,775,807
