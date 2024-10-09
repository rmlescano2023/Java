// Hackerrank 13 - Java Date and Time

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.time.LocalDate; // new import

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        
        if (year <= 2000 || year >= 3000) {     // Constraint
            return "ERROR!";
        }
        else {

            LocalDate date = LocalDate.of(year, month, day);
            String dayOfWeek = String.valueOf(date.getDayOfWeek());
            return dayOfWeek;
        
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

// VERBAL EXPLANATIONS:

// First of all, we used Java 8 in this problem so that we could import the java.time package since we are dealing with date and time.
// So, in line 14, we imported the LocalDate class from the package.

// in line 28 is where we needed to complete the "findDay" function

// in line 30 is where the constraint was applied. If the condition is true, the program will just return a string "ERROR!"

// in the else part, in line 35, we created a date object and we used the of() method to from the LocalDate class to create an instance
// from the desired year, month, and day of the month. These three are parameters of the of() method and in the form of integers.

// in line 36, we defined a String dayOfWeek, and here we used the getDayOfWeek() method of the LocalDate class. Also, we used
// the String.valuOf() method, with the getDayOfWeek() method as the parameter, mainly because you cannot simply return the value
// from getDayOfWeek() method because values from getDayOfWeek() are of Enum data type since the days of the week are considered
// as constants. Therefore, we used the String.valueOf() method because using this method returns a string representation of any argument
// that was passed. So, that's how we achieved getting the String dayOfWeek in line 36, and then in line 37, we return that value.