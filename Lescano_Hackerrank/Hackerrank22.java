// Hackerrank 22 - Java Exception Handling

import java.util.Scanner;
class MyCalculator {
    /*
    * Create the method long power(int, int) here.
    */
    
    public long power(int n, int p) throws Exception {
        if (n < 0 || p < 0 ) {
            throw new Exception ("n or p should not be negative.");
        }
        else if (n > 10 || p > 10) {    // Constraint
            throw new Exception ("n or p is out of bounds.");
        }
        else if (n == 0 && p == 0) {
            throw new Exception ("n and p should not be zero.");
        }
        else {
            return (long)Math.pow(n, p);
        }
    }
    
}

public class Solution {
    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (in .hasNextInt()) {
            int n = in .nextInt();
            int p = in .nextInt();
            
            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

// VERBAL EXPLANATIONS
// in line 9, we have the power method of "long" return type. So, that value that needs to be returned should also be of type "long".
// In the same line, we have here the "throws" keyword and this is a crucial part of the method because this keyword declares which "exceptions"
// can be thrown from the method "power" during the execution of the program.

// inside the method we have a series of if-else if statements. These statements containt constraints that should be followed in the program, and if
// detected, the program will print out an exception statement. I used the "throw" keyword so that I could custom an error, followed by the exception type,
// which I just wrote Exception, and then the error message.

// in line 10 is if either the user input of n or p is negative, the program will throw an exception "java.lang.Exception" with a custom error
// message that "n or p should not be negative".

// in line 13 is an exception for the constraint stated, that n or p should not be less than -10 or greater that 10. The negative input was handled
// already in the first exception, so in this part, the program will just check if the user inoput is greater than 10. Then the program will throw a
// custom error that n or p is out of bounds.

// then lastly in line 16 is an exception for user input n AND p if they are both zero. Then the program will throw an exception with the custom
// error that states n and p should not be zero.

// finally, in the else part in line 19, the if there are no errors found, we used the Math.pow() method with parameters n (first) and p (second) because p
// is the exponent. Also, since using Math.pow() method returns a value that is a "double" data type, I preceded it with a (long) data type inclosed in
// parentheses in order to cast its data type into "long". It's a direct way to convert between data types.