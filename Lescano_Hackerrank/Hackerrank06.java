// Hackerrank 6 - Java Loops II

import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh) {
        
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();   // t = number of queries
        
        if (t < 0 || t > 500) {
            System.out.println("Input Error"); // Error catcher
        }
        else {
            for(int i = 0; i < t; i++) {
                int a = in.nextInt(), b = in.nextInt(), n = in.nextInt();
                
                if ((a < 0 || a > 50) || (b < 0 || b > 50) || (n < 1 || n > 15)) {
                    System.out.println("Input Error"); // Error catcher
                    break;
                }
                else {
                    for (int j = 0; j < n; j++) {
                        a += Math.pow(2,j) * b;
                        System.out.print(a + " ");  // print() was used here
                    }
                    System.out.println();
                }
            }  
        }
        in.close();
        
    }
}
