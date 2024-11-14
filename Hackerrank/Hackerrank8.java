// Hackerrank 8 - Java String Reverse

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        
        /* Enter your code here. Print output to STDOUT. */
        int check = 0;
        
        if (A.length() > 50) {
            System.out.println("INPUT ERROR");  // Error catcher
        }
        else {
            
            for (int i = 0; i < A.length(); i++) {
                if (Character.isUpperCase(A.charAt(i)) == true) { // Error catcher
                    check = 2;
                    break;
                }
                else {
                    if (A.charAt(i) == A.charAt(A.length() - (i + 1))) {
                        continue;
                    }
                    else {
                        check = 1;
                    }
                }
            }
            
            switch (check){
                case 0: System.out.println("Yes");  break;  // The string is a palindrome
                case 1: System.out.println("No"); break;    // Not a Palindrome
                case 2: System.out.println("INPUT ERROR"); break;   // Error catcher, which denotes that the string contains an uppercase letter
            };
            
        }
    }
}

// VERBAL EXPLANATIONS:

// line 13: is an error catcher that if the length of the string is more than 50 characters.

// line 20: here is an if statement, which checks whether there is an uppercase letter in the string.
// If there is, the program will print an error message,
// then the break statement in line 17 will break the loop and will proceed to the end of the program. I used the method
// Character.isUpperCase() to check if a character is in uppercase or not,
// and its parameter is every character in the string which was given by the method A.charAt(i) where the charAt returns the character
// at index i. If this condition is true, the variable check will be assigned a value 2, which will be used later on.

// line 24: I have a nested if-else statement here, and this is the part that checks whether the string is a palindrome or not. I used the charAt() method again here,
// and what it does, it compares the character at the beginning of the string to the character at the end of the string, which was denoted by A.charAt(A.length() - (i + 1)).
// If this condition is true, I used the continue statement to proceed to the next iteration in the loop. In the else part, the variable check will be assigned a value 1.

// line 34: here we have a switch statement, with a parameter, the variable "check". Then, we have 3 cases: case 0 means that the string is a palindrome,
//which then prints "Yes", case 1 means that the string is not a palindrome, then prints "No", and lastly, case 2 is an Error catcher which denotes that the string contains an uppercase letter.