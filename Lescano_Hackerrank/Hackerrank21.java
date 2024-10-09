// Hackerrank 21 - Java Exception Handling (Try-catch)

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        
        try {
            int x = sc.nextInt(), y = sc.nextInt(); // Scanner needs to be included in the "try" block
            System.out.println(x / y);
        }
        catch (InputMismatchException e) {
            System.out.println("java.util.InputMismatchException");
        }
        catch (ArithmeticException e) {
            System.out.println("java.lang.ArithmeticException: / by zero");
        }
        
    }
}

// VERBAL EXPLANATIONS:

// in line 14, we have created here a scanner object named "sc".

// in line 16 we have the "try" block, and inside is where we defined x and y to scan the user input using sc.nextInt() method.
// The reason why we included this in the try block is because if there will be errors in scanning the user input, the program will
// immediately catch it.

// in line 20 we have a catch block, where the program will catch an error if the user input is not a 32-bit signed integer,
// and then it will print "java.util.InputMismatchException" this error.

// in line 23 we have another catch block, where the program will catch an error if the second user input, the variable y, is zero, because
// in that case, the division process will be undefined. Then, the program will print "java.lang.ArithmeticException: / by zero" this error.