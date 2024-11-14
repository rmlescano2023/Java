// Hackerrank 25 - Java Static Initializer Block (replaced Java Visitor Pattern)

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

//Write your code here

static int B, H;
static boolean flag = true; // default value

static {
    
    Scanner sc = new Scanner(System.in);
    
    B = sc.nextInt();
    H = sc.nextInt();
    
    if (B <= 0 || H <= 0) {
        flag = false;
        System.out.println("java.lang.Exception: Breadth and height must be positive");
    }
    else if (B > 100 || H > 100) {
        flag = false;
        System.out.println("java.lang.Exception: Input is out of bounds");

    }
    
}

public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class



// VERBAL EXPLANATIONS:

// So, static initializer blocks, these blocks are automatically executed when the class loads and it also doesn't have to be a method.
// Also, it executes in order from top to bottom, so the order really matters when using this.

// in line 11, we declared the variables B (breadth) and H (height). In the next line we defined here a boolean variable flag since this
// was used in the main method below, and the value is true so that the arithmetic process below will occur.

// Next, in line 14 the static initialization block, inside we created a scanner object for the user input, and then in lines 18 and 19,
// the program will scan for user input for B and H using the .nextInt() method.
// Then, in line 21 we have an if-else statements for the constraints, if B or H is a negative number, the program will print an error message
// that there is a negative input. Same goes for the else-if statement, if there is an input that is greater than 100, the program
// will print an error message that the input is out of bounds.