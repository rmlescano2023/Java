// Hackerrank 19 - Java Interface

import java.util.*;
interface AdvancedArithmetic{
  int divisor_sum(int n);
}

//Write your code here
class MyCalculator implements AdvancedArithmetic {
    public int divisor_sum(int n) {
        
        int sum = 0;
        
        if (n < 0 || n > 1000) {    // Constraint
            System.out.println("ERROR!");
        }
        else {
            
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {   // if the Boolean result is zero, it means that n is divisible by i
                    sum += i;
                }
            }

        }
        
        return sum;
    }
}

class Solution{
    public static void main(String []args){
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
      	sc.close();
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o){
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}



// VERBAL EXPLANATIONS:

// in line 9, here we have the MyCalculator class which implements the interface AdvancedArithmetic in the locked portion of the code above, this means that the MyCalculator class
// can now access the interface method that the AdvancedArithmetic have, which is the divisor_sum() method. The body of this method is provided inside the MyCalculator class.

// in line 12, we defined a variable sum equel to zero which will be used later on.

// in line 14, here we have a constraint that if ever n is a negative number or is greater than 1000.

// In the else part, for the major part of the program, in line 19, we have a for loop, and the purpose of this loop is to check every number from 1 to n (including n) if they are divisors of n.
// Following the condition (n % i == 0), if the Boolean result is zero, it means that n is divisible by i. Meaning that "i" is a divisor of n. If that is true, the variable sum
// will be added by "i". It will iterate every number from 1 to n, and the value of "sum" will continue to be added by the divisors. Then, after the loop is done,
// the program will return the variable sum, which is already the sum of all the divisors.