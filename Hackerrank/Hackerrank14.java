// Hackerrank 14 - Java Strings Introduction

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        
        System.out.println(A.length() + B.length());
        System.out.println( (A.charAt(0) - 'a' > B.charAt(0) - 'a') ? "Yes" : "No" );
        
        String capitalizeA = A.substring(0,1).toUpperCase() + A.substring(1);
        String capitalizeB = B.substring(0,1).toUpperCase() + B.substring(1);
        
        System.out.printf("%s %s", capitalizeA, capitalizeB);
        
    }
}

// VERBAL EXPLANATIONS:
// in line 13, it's just a simple addition of the lengths of the two strings using the length() method.

// in line 14, what I did here is I got the first character of both strings using the charAt() method, and then subtracted it with lowercase character "a".
// Subtraction between characters results to an ASCII value. For example, if the first letter of string A is "j" (in java), which holds an ASCII value of 106, minus
// character "a", which holds an ASCII value of 97, then we will get an integer value of 9. That's what's happening here. So if the integer value retrieved from
// the first letter of string A is greater than the value of the first letter of string B, then the program will print "Yes". If not, print "No". I also used
// a shorthand If...Else syntax to write this in one line since this is just a simple If...Else statement.

// in lines 16 and 17, what I did here is I divided each string into two parts using the .substring() method because we need to capitalize the first letter.
// The parameters inside the .substring() method are the beginningIndex and the endIndex, which denotes which part of the string will be returned as a substring.
// In this case, the beginningIndex is zero and the endIndex is one. The beginningIndex includes the value at that index, but the endIndex does not, which means that
// values before the endIndex will only be the ones to be returned, not including the value at that index.
// So, the first part is I got the first letter, then I also used the .toUpperCase() method to instantly capitalize the first letter. It is then followed by another
// substring which is the remaining letters of the string. It only has a parameter 1, the beginningIndex, the endIndex was not explicitly stated because it will automatically
// return the values unil the end of the string. So, only the beginningIndex is required. The value is 1 because it is the second letter in the string.

// Lastly, in line 19, the strings A and B with a capitalized first letter is printed.