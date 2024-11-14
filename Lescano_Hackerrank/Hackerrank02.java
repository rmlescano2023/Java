// Hackerrank 2 - Java Stdin and Stdout II

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();

        double d = scan.nextDouble(); // Write your code here.
        scan.nextLine(); // EXPLANATION BELOW
        String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}

// In line #10, the purpose of the scan.nextLine() is to scan the end of line after the "double" input before the String.

// Verbal explanation:
// So upon running the code, when you type-in the integer and you hit "Enter" key, the compiler will read the invisible automatic command at end of the line
// which is the "\n" (forward slash n) or the newline that was left in the input stream.
// Therefore, there needs to be an extra scan method in order to make sure that the compiler reads the exact line where you input the String variable.
