// Hackerrank 23 - Java Factory Pattern

import java.util.*;
import java.security.*;
interface Food {
	 public String getType();
	}
	class Pizza implements Food {
	 public String getType() {
	 return "Someone ordered a Fast Food!";
	 }
	}

	class Cake implements Food {

	 public String getType() {
	 return "Someone ordered a Dessert!";
	 }
	}
	class FoodFactory {
		public Food getFood(String order) {

// Write your code here

    if (order.toLowerCase().equals("pizza")) {
        return new Pizza();
    }
    else if (order.toLowerCase().equals("cake")) {
        return new Cake();
    }
    return null;

}//End of getFood method

	}//End of factory class

	public class Solution {

	 public static void main(String args[]){
			Do_Not_Terminate.forbidExit();

		try{

			Scanner sc=new Scanner(System.in);
			//creating the factory
			FoodFactory foodFactory = new FoodFactory();
	
			//factory instantiates an object
			Food food = foodFactory.getFood(sc.nextLine());
	
			
			System.out.println("The factory returned "+food.getClass());
			System.out.println(food.getType());
		}
		catch (Do_Not_Terminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	 }

	}
	class Do_Not_Terminate {
		 
	    public static class ExitTrappedException extends SecurityException {

			private static final long serialVersionUID = 1L;
	    }
	 
	    public static void forbidExit() {
	        final SecurityManager securityManager = new SecurityManager() {
	            @Override
	            public void checkPermission(Permission permission) {
	                if (permission.getName().contains("exitVM")) {
	                    throw new ExitTrappedException();
	                }
	            }
	        };
	        System.setSecurityManager(securityManager);
	    }
	}

// VERBAL EXPLANATIONS:
// This problem got me pretty confused for a while just because I didn't have existing knowledge about the difference of two methods or process for comparison.

// So we have an interface Food here in line 3, with an interface method called getType(), and then we have 2 classes, Pizza and Cake, whcih implements the method of interface
// Food. And inside the Pizza and Cake class is where the body of the method was provided, but with different contents.

// So, in line 25 is where our code starts, inside the getFood method which takes in a String parameter, which is also inside the foodFactory class.
// Basically, in this problem, the Factory Pattern requires us to return, not a primitive data type, but an object from some other method call.

// in line 44, a "foodFactory" object was created, the object for FoodFactory class in line 18.
// Next, in line 47, is where the user input is taken. What happened here is we created an object for the interface Food, and its value depends on what the user
// has inputted. The value accessed the class FoodFactory in line 18, by using the object foodFactory created here in line 44, and it used the getFood() method
// with an argument "sc.nextLine()" which denotes the user input.

// So, in the getFood() method, it takes in a String value with a variable name "order".
// Then, in the if statement, the condition says that if the user input is "pizza", the program will return a new object Pizza(). In the else-if part, if the user
// input is "cake", then the program will return a new object Cake(). Basically, the return value is not a primitive data type, but a class, and the destination
// of this return statement will be the value of object "food" created in line 47. Therefore, this "food" object will now have access to the attributes or
// methods of either the Pizza class in line 6, or the Cake class in line 12, depending on the user input.
// Afterwards, the program will give an output from line 50, and in here, the program used the getClass() method to take whatever the class is being used now.
// Then, in line 51, the getType() method will now be called, either it will print what was given in the body of Pizza classor in Cake class.

// Lastly, another very crucial part in this code is the condition inside the if-else statements. This is what I was referring to from what I said earlier.
// In here, we used the .equals() method to compare the value of the variable "order" with either "cake" or "pizza". The first time I tried answering this problem,
// I used the double equals (==) operator, but I cannot pass the test cases. Then, I found out that the double equals (==) and the .equals() method are both
// used for comparisons, but can serve different purposes based on the objective of the program. So, basically, the equality operator can be used to compare
// any primitive data types and some object types. But if we apply == for object types then, there should be compatibility between arguments types
// (either child to parent or parent to child or same type). Otherwise, we will get a compile-time error.
// The .equals() method, on the other hand, compares the two given strings based on the CONTENT of the string, and since, here, we are comparing the OBJECT "order",
// we needed to get the content of the object "order" and compare it with another String object "pizza" or "cake" in the parameter of the .equals() method.
// When we are comparing 2 String objects by .equals() operator, then we are checking if both objects contain the same data or not.
// When we use the equality "==" operator for comparison, the program is checking if both objects have the same addresses in the string constant pool.
// And that is why the .equals() method is the appropriate one to use in this case.

// We also used the .toLowerMethod() to be safe if ever the user input contains a capital letter.

// And at the end, in line 29, the program will return null if no conditions were satisfied.