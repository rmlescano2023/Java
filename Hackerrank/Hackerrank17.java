// Hackerrank 17 - Java Inheritance II (replaced Java Covariant Return Types)

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//Write your code here
class Arithmetic {
    public int add (int x, int y) {
        return x + y;
    }
}

class Adder extends Arithmetic {    // does not need anything inside since it inherits from class Arithmetic
    
}

public class Solution{
    public static void main(String []args){
        // Create a new Adder object
        Adder a = new Adder();
        
        // Print the name of the superclass on a new line
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());	
        
        // Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
        System.out.print(a.add(10,32) + " " + a.add(10,3) + " " + a.add(10,10) + "\n");
     }
}

// VERBAL EXPLANATIONS:

// in line 10, we have the class Arithmetic, and inside is its method named "add", which takes in 2 integers, "x" and "y", and the method returns the sum of x and y.
// This class is also the superclass since this is the one being inherited from.

// and in line 16 we have the Adder class which is the subclass because this class inherits from the Arithmetic class, which means that any attributes or methods from
// the superclass can also be used by this subclass. It also does not need to put anything inside since the method used in the main function below is from the Arithmetic class.
// It was only needed that we created an object of the Adder class in order to access the add() method from the Arithmetic class.