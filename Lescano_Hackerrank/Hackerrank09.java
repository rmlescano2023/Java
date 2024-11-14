// Hackerrank 9 - Java Anagrams

import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        
        boolean ret = true;    // set default value
        int[] frequencies = new int[26];
        int index;
                
        for (int i = 0; i < a.length(); i++) {
            
            int asciiValueA = a.charAt(i), asciiValueB = b.charAt(i);   
            char currentA = Character.toLowerCase(a.charAt(i)), currentB = Character.toLowerCase(b.charAt(i));
            int indexA = currentA - 'a', indexB = currentB - 'a';
            
            if (a == null || b == null || a.length() > 50 || b.length() > 50 || a.length() != b.length() || asciiValueA < 65 || asciiValueA > 122 || asciiValueB < 65 || asciiValueB > 122) {
                ret = false;    // Constraint 1 & 2
                break;
            }
            else {
                
                frequencies[indexA]++;
                frequencies[indexB]--;
                
            }
            
        }
        
        for (int i = 0; i < 26; i++) {
            
            if (frequencies[i] != 0) {
                ret = false;
                break;
            }
            
        }
        
        return ret;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

// VERBAL EXPLANATIONS:

// in line 9, here I created an integer Array named "frequencies", and the array size was set to 26 which corresponds to the alphabet of 26 letters.
// So this array is going to be initialized to zero, meaning I have 26 zeroes in the array.
// This will be explained more later on.

// in line 14, I defined two integer variables here which gets the ASCII value of the character of strings A and B at index "i" as is, 
// meaning it may be in lowercase or uppercase since the ASCII value of a lowercase
// and uppercase letter are different. This will be used for error handling later on.

// in line 15, I defined two character variables here which gets the current character of the strings A and B at index "i", but in lowercase. 
// So I used the Character.toLowerCase() method in order to achieve that.

// in line 16, I defined two integer variables here which gets the index value of a letter in the alphabet. So, for example, currentA is lowercase letter B, its value in the ASCII table is 98, then
// we subtract that by the ASCII value of lowercase character A, which is 97, so 98 minus 97 is 1, therefore the index value of B in the array is 1. Subtracting characters automatically converts to
// an ASCII number, so the result will be associated with the position of the letter in the "frequencies" array that I defined a while ago.

// Moving on, in line 18, here we have an error handler for the constraints that were mentioned....

// In the else part, I have here the array frequencies at indexA, the value will be incremented, then in the next line, at indexB on the other hand, the value will be decremented.
// The purpose of this is that if both strings are anagrams, then the result of the "frequencies" array will all be zero.
// For example, if string A has a letter F, then the position of F in the array will be incremented by 1. If string B also has a letter F, the position of F in the array
// will be decremented by 1, which means the the value at F will revert back to zero.
// If ever string A has 3 letter A's, then the value at A in the array will be incremented thrice, therefore the current value is 3. But, if ever string B only has 2 letter A's,
// the value at A in the array will only be decremented twice, which means that the resulting value of A in the array is 1, which means that string A and B are not anagrams.

// in line 31, we have here the last step which checks the whole array if there is a single value that is not equal to zero, then the program will set the value of the boolean variable "ret" to false,
// because this means that the strings aren't anagrams. Then the break statement was used to stop the loop.

// and then in line 40, the variable "ret" will be returned.
