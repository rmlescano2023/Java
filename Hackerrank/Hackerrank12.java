// Hackerrank 12 - Java ArrayList

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        
        if (n < 1 || n > 20000) {   // Constraint 1
            System.out.println("ERROR!");
        }
        else {  // PART 1
            
            Boolean proceed = true;
        
            for (int i = 0; i < n; i++) {
                
                int d = sc.nextInt();
                
                ArrayList<Integer> inner = new ArrayList<>();
                
                if (d < 0 || d > 50000) {   // Constraint 2
                    System.out.println("ERROR!");
                    proceed = false;
                    break;
                }
                else {

                    for (int j = 0; j < d; j++) {

                        inner.add(sc.nextInt());

                    }
                    
                    outer.add(inner);
                
                }
                
            }
        

            if (proceed == true) {  // PART 2

                int q = sc.nextInt();
                
                if (q < 1 || 1 > 1000) {    // Constraint 3
                    System.out.println("ERROR!");
                }
                else {
                    
                    for (int i = 0; i < q; i++) {

                        int x = sc.nextInt(), y = sc.nextInt();

                        try {

                            System.out.println(outer.get(x - 1).get(y - 1));

                        }
                        catch (Exception e) {

                            System.out.println("ERROR!");   // Constraint 4

                        }

                    }
                
                }
            
            }
        
        }
        
    }
    
}

// VERBAL EXPLANATIONS:
// in line 12, I created an object for the user input
// in line 13, I defined a variable n, and it's for scanning the very first user input, which is also the size of our 2D ArrayList

// in line 15, here I defined the 2D ArrayList. So we typed in the ArrayList syntax, and inside the angle brackets is what we want to store which is another ArrayList of Integers,
// this is what this ArrayList will be taking in, and this is named as the "outer" ArrayList.

// in line 19, I have the first constraint for n for how many arrays of integers will be needed, which will just print ERROR! if the condition is true.
// In the else part, we have the first major step in the program.

// in line 24, I defined a Boolean variable with a default value of true, and this will be used later on in the program.

// in line 26, I have a for loop, and this will be responsible for taking in the user inputs in the first part of the program, which is the arrays of integers.
// Every iteration in this for loop represents every line which holds an array of integers. In simpler terms, this is the inner array of our 2D array.

// in line 28, an integer "d" is defined, which denotes the number of integer values to be scanned in the current line.

// in line 30, here another ArrayList was defined, which will hold the integers of each line in the inner arrays.

// in line 32 is for the second constraint for d, which will also print ERROR if the condition is true, and then set the Boolean variable to false. This part is crucial
// whether the program will proceed to the second part or not.
// In the else part, I have a for loop which will be responsible for scanning the integers to be included in the current line. I used the add() method, and
// the parameter will be the user input, which was written as sc.nextInt(). So it will loop for "d" number of times, or the number of integers and will add
// every input to the "inner" ArrayList on that current line. After this loop, the "inner" ArrayList will be added to the "outer" ArrayList, as can be seen in line 45,
// which will then serve as the array of integers at the current index of the "outer" ArrayList. The loop will repeat until "n" number of ArrayLists in the "outer" ArrayList.

// in line 52 starts the second part of the program, but before that, if there are errors in the first part of the program, remember that the Boolean variable "proceed" will
// have a value of false, so if that's the case, the program will not go through this "if" part and just continue to the end of the program. If there are no errors, the
// second part of the program will proceed.

// in line 54 I have a variable "q" which denotes the number of queries, and in line 56 is the 3rd constraint for "q".

// in line 61 I have a for loop, which will be responsible for taking in every input from the user, will print whatever value the user will ask for.

// in line 63, the variable "x" denotes which line of the array of integers will be accessed, and the variable "y" denotes the index of the integer that the user asked for to be returned.

// in line 67 is where the value will be printed. So in order to access the integer that the user asked, the program will access the "outer" ArrayList using two get() methods.
// The first get() method will access which line of array of integers that the user wanted, and the parameter is (x - 1) since the index of my ArrayList starts from zero
// (unlike the diagram that was shown in the Hackerrank problem). Then, the second get() method will acces the index of the integer at that current line. The parameter here
// is also (y - 1) because the inner array's indexes started from zero. After that, the integer at line "x" and at index "y" should be printed.

// Lastly, the catch part in line 70 will just print ERROR if ever there are errors in the process, and will also serve as the 4th constraint.