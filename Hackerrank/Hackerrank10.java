// Hackerrank 10 - Java 1D Array

import java.util.*;

public class Solution {

    public static void main(String[] args) {
	   
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] a = new int[n];   // create an array of size n
        
        for (int i = 0; i < n; i ++) {
            int val = scan.nextInt();   // store the following integers to variable "val"
            a[i] = val;                 // then stores the value of "val" at index i in the array "a"
        }


        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}