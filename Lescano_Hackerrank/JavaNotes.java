//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PART 1 - Intro/Recall
// NOTE: in running the code in CMD, (1) compile the program, type "javac Filename.java", the (2) to run the program, type "java Filename"

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Basic Hello World Java codeblock

public class JavaNotes {
    public static void main (String[] args) {
        System.out.println("Hello World!");
    }
}

public class JavaNotes {
    public static void main(String[] args){
        System.out.print(args[1]);  // what this does is it accesses the array String[]
    }                               // args[1] refers to the string passed before executing the java file in the cmd
                                    // EX: java Test.java Renmar Lescano - write this in the command line after compiling the program
                                    // output of args[1] is "Lescano" - the second string that was passed
                                    // Note: it is important to put a space after the.java, and spaces every after a string

// NOTE: A public class needs to match the filename, i.e.: public class JavaNotes {} == JavaNotes.java
// Two or more classes are allowed in the same file, but only ONE "public class" is allowed.
// "public" and "private" class are access modifiers

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Data Types:
// String - stores text, such as "Hello". String values are surrounded by double quotes
// int - stores integers (whole numbers), without decimals, such as 123 or -123
// float - stores floating point numbers, with decimals, such as 19.99 or -19.99
// char - stores single characters, such as 'a' or 'B'. Char values are surrounded by single quotes
// boolean - stores values with two states: true or false

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Recall, Java Logical Operators:
// && - and; Returns true if both statements are true
// || - or; Returns true if one of the statements is true
// !  - not; Reverse the result, returns false if the result is true

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Strings:
// length of a string can be determined using the length() method:
String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
System.out.println("The length of the txt string is: " + txt.length());

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- toUpperCase() and toLowerCase() methods:
String txt = "Hello World";
System.out.println(txt.toUpperCase());   // Outputs "HELLO WORLD"
System.out.println(txt.toLowerCase());   // Outputs "hello world"

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- The indexOf() method:
// returns the index (the position) of the first occurrence of a specified text in a string (including whitespace):
String txt = "Please locate where 'locate' occurs!";
System.out.println(txt.indexOf("locate")); // Outputs 7

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- String Concatenation:
// The + operator can be used between strings to combine them:
String firstName = "John";
String lastName = "Doe";
System.out.println(firstName + " " + lastName);     // Outputs "John Doe"

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- You can also use the concat() method to concatenate two strings:
String firstName = "John "; // notice that there is a space after John, to denote space between the first name and last name
String lastName = "Doe";
System.out.println(firstName.concat(lastName));     // Outputs "John Doe"

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Special Characters:
// The backslash (\) escape character turns special characters into string characters, i.e. \'. \", and \\:
String txt = "It\'s alright.";      // Output: It's alright.
String txt = "We are the so-called \"Vikings\" from the north.";    // Output: We are the so-called "Vikings" from the north.
String txt = "The character \\ is called backslash.";   // Output: The character \ is called a backslash.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Other escape sequences in Java:
// \n - new line
// \r - carriage return ?
// \t - tab
// \b - backspace
// \f - form feed ?
// \u2028 - line separator
// \u2029 - paragraph separator
// \u0085 - next line
// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?"); - Removing any of carriage return, newline, line separator, paragraph separator,
//                                                     next line characters and the carriage return/newline pair in particular. 
//                                                     The “|” means “or” and the “[]” enclose a list from which you choose “any of”.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Math class:
// The Math.max(x,y) method can be used to find the highest value of x and y:
Math.max(5, 10);    // Output: 10

// The Math.min(x,y) method can be used to find the lowest value of x and y:
Math.min(5, 10);    // Output: 5

// The Math.sqrt(x) method returns the square root of x:
Math.sqrt(64);  // Output: 8

// The Math.abs(x) method returns the absolute (positive) value of x:
Math.abs(-4.7); // Output: 4.7

// The Math.random() returns a random number between 0.0 (inclusive), and 1.0 (exclusive):
Math.random();

// The Math.pow(a,b) method can be used to solve numbers with exponents:
Math.pow(2, 3); // This is 2 cubed

// To get more control over the random number, e.g. you only want a random number between 0 and 100, you can use the following formula:
int randomNum = (int)(Math.random() * 101);  // 0 to 100

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Boolean Values
// A boolean data type is declared with the boolean keyword and can only take the values true or false:
boolean isJavaFun = true;
boolean isFishTasty = false;
System.out.println(isJavaFun);     // Outputs true
System.out.println(isFishTasty);   // Outputs false

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Boolean Expression
// A Boolean expression is a Java expression that returns a Boolean value: true or false.
// You can use a comparison operator, such as the greater than (>) or less than (<) operator to find out if an expression (or a variable) is true:
int x = 10;
int y = 9;
System.out.println(x > y); // returns true, because 10 is higher than 9

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Conditions and If Statement
// if, else, and else if syntax:
int time = 22;
if (time < 10) {
    System.out.println("Good morning.");
}
else if (time < 20) {
    System.out.println("Good day.");
}
else {
    System.out.println("Good evening.");
}
// Outputs "Good evening."

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Short Hand If...Else (Ternary Operator)
// There is also a short-hand if else, which is known as the ternary operator because it consists of three operands.
// It can be used to replace multiple lines of code with a single line. It is often used to replace simple if else statements:

// Syntax: variable = (condition) ? expressionTrue :  expressionFalse;

// Instead of writing:
int time = 20;
if (time < 18) {
  System.out.println("Good day.");  
}
else {
  System.out.println("Good evening.");
}

// You can simply write:
int time = 20;
String result = (time < 18) ? "Good day." : "Good evening.";
System.out.println(result);

// or you can do it like this:
System.out.println( (asciiValueA < 65 || asciiValueA > 122 || asciiValueB < 65 || asciiValueB > 122) ? "ERROR" : "OKAY" );

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Switch
// Use the switch statement to select one of many code blocks to be executed. 
switch(expression) {
    case x:
      // code block
      break;
    case y:
      // code block
      break;
    default:
      // code block
// Example:
int check = 1;

switch (check){
  case 0: System.out.println("Yes");  break;
  case 1: System.out.println("No"); break;
  case 2: System.out.println("INPUT ERROR");
};
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Loops

//-------------------------------------------------------------------------------------------------------------------------------------- While Loop
// The while loop loops through a block of code as long as a specified condition is true:
// Syntax:
while (condition) {
    // code block to be executed
}
// Example:
int i = 0;
while (i < 5) {
  System.out.println(i);
  i++;
}

//-------------------------------------------------------------------------------------------------------------------------------------- Do/While Loop
// The do/while loop is a variant of the while loop. This loop will execute the code block once,
// before checking if the condition is true, then it will repeat the loop as long as the condition is true.
// Syntax:
do {
    // code block to be executed
}
while (condition);
// Example:
int i = 0;
do {
  System.out.println(i);
  i++;
}
while (i < 5);

//-------------------------------------------------------------------------------------------------------------------------------------- For Loop
// When you know exactly how many times you want to loop through a block of code, use the for loop instead of a while loop:
// Syntax:
for (statement 1; statement 2; statement 3) {
    // code block to be executed
}
// Statement 1 is executed (one time) before the execution of the code block. (INITIALIZATION)
// Statement 2 defines the condition for executing the code block. (CONDITION)
// Statement 3 is executed (every time) after the code block has been executed. (THEN STATEMENT)
// Example:
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}

//-------------------------------------------------------------------------------------------------------------------------------------- For Each Loop
// There is also a "for-each" loop, which is used exclusively to loop through elements in an array:
for (type variableName : arrayName) {
    // code block to be executed
}
// Example:
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
for (String i : cars) {
  System.out.println(i);
}

//-------------------------------------------------------------------------------------------------------------------------------------- Java Break and Continue
// The break statement can also be used to jump out of a loop. Example:
for (int i = 0; i < 10; i++) {
    if (i == 4) {
      break;
    }
    System.out.println(i);
}

// The continue statement breaks one iteration (in the loop), if a specified condition occurs, and continues with the next iteration in the loop. Example:
for (int i = 0; i < 10; i++) {
    if (i == 4) {
      continue;
    }
    System.out.println(i);
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Arrays
// Arrays are used to store multiple values in a single variable, instead of declaring separate variables for each value.
// To declare an array, define the variable type with square brackets:
String[] cars;
// We have now declared a variable that holds an array of strings. To insert values to it, we can use an array literal,
// place the values in a comma-separated list, inside curly braces:
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
// To create an array of integers, you could write:
int[] myNum = {10, 20, 30, 40};

// Or, if you don't currently have the values, you can write:
int[] myNum = new int[4]; // this will create an array with a size of 4
// then, when you want to store an element in the array at a certain position, you can write:
myNum[3] = 12;  // which means you want to store the element 12 at index 3 of the array   -   [0, 0, 0, 12]


//-------------------------------------------------------------------------------------------------------------------------------------- Accessing the Elements of an Array
// You access an array element by referring to the index number. Example:
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
System.out.println(cars[0]);    // Outputs Volvo

//-------------------------------------------------------------------------------------------------------------------------------------- Change an Array Element
// To change the value of a specific element, refer to the index number:
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
cars[0] = "Opel";
System.out.println(cars[0]);    // Now outputs Opel instead of Volvo

//-------------------------------------------------------------------------------------------------------------------------------------- Array Length
// To find out how many elements an array has, use the length property:
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
System.out.println(cars.length);    // Outputs 4

//-------------------------------------------------------------------------------------------------------------------------------------- Loop Through an Array
// You can loop through the array elements with the for loop, and use the length property
//to specify how many times the loop should run.
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
for (int i = 0; i < cars.length; i++) {
  System.out.println(cars[i]);
}

//-------------------------------------------------------------------------------------------------------------------------------------- Loop Through an Array with For-Each
// There is also a "for-each" loop, which is used exclusively to loop through elements in arrays. Example:
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
for (String i : cars) {
  System.out.println(i);
}
// The example above can be read like this: for each String element (called i - as in index) in cars, print out the value of i.
// If you compare the for loop and for-each loop, you will see that the for-each method is easier to write,
//it does not require a counter (using the length property), and it is more readable.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Multidimensional Arrays
// To create a two-dimensional array, add each array within its own set of curly braces:
int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };

// To access the elements of the myNumbers array, specify two indexes: one for the array, and one for the element inside that array.
//This example accesses the third element (2) in the second array (1) of myNumbers:
int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
int x = myNumbers[1][2];
System.out.println(x); // Outputs 7

// We can also use a for loop inside another for loop to get the elements of a two-dimensional array (we still have to point to the two indexes):
public class Main {
    public static void main(String[] args) {
      int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
      for (int i = 0; i < myNumbers.length; ++i) {
        for(int j = 0; j < myNumbers[i].length; ++j) {
          System.out.println(myNumbers[i][j]);
        }
      }
    }
  }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Other

// NOTE: println() - there is an invisible "\n" at the end of the line, while in print() there isn't.
//       So, print() is useful when you want to print multiple characters in a single line.

int index = a-'a';  // character at a minus 'a' gets the ASCII value

// For a variable, declaration means just stating its data type along with giving it name for memory allocation; while definition means giving the value of that variable.

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PART 2 - Java Methods

// A method is a block of code which only runs when it is called. You can pass data, known as parameters, into a method.
// Methods are used to perform certain actions, and they are also known as "functions".
// Why use methods? To reuse code: define the code once, and use it many times.

// Create a Method
// A method must be declared within a class. It is defined with the name of the method, followed by parentheses ().
// Java provides some pre-defined methods,such as System.out.println(), but you can also create your own methods to perform certain actions:
public class Main {
  static void myMethod() {
    // code to be executed
  }
}
// myMethod() is the name of the method
// "static" means that the method belongs to the Main class and not an object of the Main class. You will learn more about objects and
// how to access methods through objects later in this tutorial. "void" means that this method does not have a return value.

// Call a Method
// To call a method in Java, write the method's name followed by two parentheses () and a semicolon;
public class Main {

  static void myMethod() {
    System.out.println("I just got executed!");
  }

  public static void main(String[] args) {
    myMethod(); // Outputs "I just got executed!"
  }

}

// A method can also be called multiple times:
public class Main {
  static void myMethod() {
    System.out.println("I just got executed!");
  }

  public static void main(String[] args) {
    myMethod();
    myMethod();
    myMethod();
  }
}
// OUTPUT:
// I just got executed!
// I just got executed!
// I just got executed!

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Method Parameters
// Information can be passed to methods as parameter. Parameters act as variables inside the method.
// Parameters are specified after the method name, inside the parentheses. You can add as many parameters as you want, just separate them with a comma.
// The following example has a method that takes a String called fname as parameter. When the method is called, we pass along a first name,
// which is used inside the method to print the full name:
public class Main {
  static void myMethod(String fname) {
    System.out.println(fname + " Refsnes");
  }

  public static void main(String[] args) {
    myMethod("Liam");
    myMethod("Jenny");
    myMethod("Anja");
  }
}
// Liam Refsnes
// Jenny Refsnes
// Anja Refsnes

// When a parameter is passed to the method, it is called an "argument". So, from the example above: fname is a parameter,
// while Liam, Jenny and Anja are arguments.

// You can have as many parameters as you like:
public class Main {
  static void myMethod(String fname, int age) {
    System.out.println(fname + " is " + age);
  }

  public static void main(String[] args) {
    myMethod("Liam", 5);
    myMethod("Jenny", 8);
    myMethod("Anja", 31);
  }
}
// Liam is 5
// Jenny is 8
// Anja is 31

// Note that when you are working with multiple parameters, the method call must have the same number of arguments as there are parameters,
// and the arguments must be passed in the same order.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Return Values
// The void keyword, used in the examples above, indicates that the method should not return a value. If you want the method to return a value,
// you can use a primitive data type (such as int, char, etc.) instead of void, and use the return keyword inside the method:
public class Main {
  static int myMethod(int x) {
    return 5 + x;
  }

  public static void main(String[] args) {
    System.out.println(myMethod(3));
  }
}
// Outputs 8 (5 + 3)

// This example returns the sum of a method's two parameters:
public class Main {
  static int myMethod(int x, int y) {
    return x + y;
  }

  public static void main(String[] args) {
    System.out.println(myMethod(5, 3));
  }
}
// Outputs 8 (5 + 3)

// You can also store the result in a variable (recommended, as it is easier to read and maintain):
public class Main {
  static int myMethod(int x, int y) {
    return x + y;
  }

  public static void main(String[] args) {
    int z = myMethod(5, 3);
    System.out.println(z);
  }
}
// Outputs 8 (5 + 3)

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Method Overloading
// With method overloading, multiple methods can have the same name with different parameters:
int myMethod(int x)
float myMethod(float x)
double myMethod(double x, double y)

// Example:
static int plusMethod(int x, int y) {
  return x + y;
}

static double plusMethod(double x, double y) {
  return x + y;
}

public static void main(String[] args) {
  int myNum1 = plusMethod(8, 5);
  double myNum2 = plusMethod(4.3, 6.26);
  System.out.println("int: " + myNum1);
  System.out.println("double: " + myNum2);
}

// Multiple methods can have the same name as long as the number and/or type of parameters are different.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Method Scope
// In Java, variables are only accessible inside the region they are created. This is called "scope".

// Variables declared directly inside a method are available anywhere in the method following the line of code in which they were declared:
public class Main {
  public static void main(String[] args) {

    // Code here CANNOT use x

    int x = 100;

    // Code here can use x
    System.out.println(x);
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Block Scope
// A block of code refers to all of the code between curly braces {}. Variables declared inside blocks of code are only
// accessible by the code between the curly braces, which follows the line in which the variable was declared:
public class Main {
  public static void main(String[] args) {

    // Code here CANNOT use x

    { // This is a block

      // Code here CANNOT use x

      int x = 100;

      // Code here CAN use x
      System.out.println(x);

   } // The block ends here

  // Code here CANNOT use x

  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Recursion
// Recursion is the technique of making a function call itself. This technique provides a way to break
// complicated problems down into simple problems which are easier to solve.
// Example:
public class Main {

  public static void main(String[] args) {

    int result = sum(10);
    System.out.println(result);

  }

  public static int sum(int k) {

    if (k > 0) {
      return k + sum(k - 1);
    }
    else {
      return 0;
    }

  }

}
// When the sum() function is called, it adds parameter k to the sum of all numbers smaller than k and returns the result. When k becomes 0, the function just returns 0.
// Since the function does not call itself when k is 0, the program stops there and returns the result.

// Halting Condition
// Just as loops can run into the problem of infinite looping, recursive functions can run into the problem of infinite recursion. Infinite recursion is when the function
//never stops calling itself. Every recursive function should have a halting condition, which is the condition where the function stops calling itself.
//  In the previous example, the halting condition is when the parameter k becomes 0.

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PART 3 - Java Classes/Objects

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java OOP
// OOP stands for Object-Oriented Programming.
// Procedural programming is about writing procedures or methods that perform operations on the data,
// while object-oriented programming is about creating objects that contain both data and methods.

// Tip: The "Don't Repeat Yourself" (DRY) principle is about reducing the repetition of code. You should extract out the codes that
// are common for the application, and place them at a single place and reuse them instead of repeating it.

// Instance - a concrete occurrence of something
// Instantiate - realization of an abstraction such as a class of objects or a computer process
// Class - template for objects; EX: Fruit
//       - it's like an object constructor, or a "blueprint" for creating objects
// Object - instance of a class; EX: Apple, Banana, Mango
//        - holds all the variables and methods (tasks the program will perform) of a class
//        - an object has Attributes and Methods (EX: a car is an object, its Attributes are its weight and color, its Methods are to drive or o brake)

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Classes/Objects


// To create a class, use the keyword class:
public class Main {
  int x = 5;
}

// To create an "object of Main", specify the class name, followed by the object name, and use the keyword "new", the className():
// Let Main = JavaNotes in this case
public class Main {
  int x = 5;

  public static void main(String[] args) {
    Main myObj = new Main();  // here
    System.out.println(myObj.x);
  }
}

// NOTE: myObj.x - the dot operator accesses the object "myObj" which is the class "JavaNotes", and its variable "x"

// It is important that after creating an object, there will be a method made in the same {}

// You can also create multiple objects of one class
public class Main {
  int x = 5;

  public static void main(String[] args) {
    Main myObj1 = new Main();  // Object 1
    Main myObj2 = new Main();  // Object 2
    System.out.println(myObj1.x);
    System.out.println(myObj2.x);
  }
}

// You can also use Multiple Classes for better organization, i.e. one class has all the attributes and methods
// while the other class holds the main() class for the codes to be executed.
// But, this needs to have 2 files in the same directory. For example:
// Main.java
public class Main {
    int x = 5;
}

// Second.java
class Second {
    public static void main (String[] args) {
        Main object1 = new Main();
        System.out.println(object1.x);
    }
}

// Then, you need to compile both java files first, then run Second.java file because the method is contained there.
// Output will be: 5

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Attributes

// Variable definitions in a class are basically called "attributes", or you can say CLASS ATTRIBUTES ARE VARIABLES WITHIN A CLASS.
// Another term for class attributes is "fields".

// You can access attributes by creating an object of the class, and by using the dot syntax (.):
public class Main {
  int x = 5;

  public static void main(String[] args) {
    Main myObj = new Main();
    System.out.println(myObj.x);
  }
}

// You can also modify attribute values by declaring the value with the object created:
public class Test {
    int x;

    public static void main (String[] args) {
        Test myObj = new Test();
        myObj.x = 40;
        System.out.println(myObj.x);
    }
}

// Or even overwrite the existing value:
public class Main {
  int x;

  public static void main(String[] args) {
    Main myObj = new Main();
    myObj.x = 40;
    System.out.println(myObj.x);
  }
}
// Output will be: 40

// You can also set the attribute to be non-overwritable by using a Modifier "final" or  the "final" keyword:
public class Main {
  final int x = 10;

  public static void main(String[] args) {
    Main myObj = new Main();
    myObj.x = 25; // will generate an error: cannot assign a value to a final variable
    System.out.println(myObj.x);
  }
}
// The final keyword is useful when you want a variable to always store the same value, like PI (3.14159...).
// The final keyword is called a "modifier".

// If you create multiple objects of one class, you can change the attribute values in one object, without affecting the attribute values in the other:
public class Main {
  int x = 5;

  public static void main(String[] args) {
    Main myObj1 = new Main();  // Object 1
    Main myObj2 = new Main();  // Object 2
    myObj2.x = 25;
    System.out.println(myObj1.x);  // Outputs 5
    System.out.println(myObj2.x);  // Outputs 25
  }
}

// You can also specify as many attributes as you want:
public class Main {
  String fname = "John";
  String lname = "Doe";
  int age = 24;

  public static void main(String[] args) {
    Main myObj = new Main();
    System.out.println("Name: " + myObj.fname + " " + myObj.lname);
    System.out.println("Age: " + myObj.age);
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Class Methods
// You learned from the Java Methods chapter that methods are declared within a class, and that they are used to perform certain actions:
public class Main {

  static void myMethod() {
    System.out.println("Hello World!");
  }

  public static void main(String[] args) {
    myMethod();
  }
}
// Outputs "Hello World!"


// Static VS Non-Static
// In the example above, we created a "static" method, which means that it can be accessed without creating an object of the class,
// unlike "public", which can only be accessed by objects:

// STATIC METHODS CAN BE CALLED WITHOUT CREATING OBJECTS
// PUBLIC METHODS MUST BE CALLED BY CREATING OBJECTS

public class Main {

  // Static method
  static void myStaticMethod() {
    System.out.println("Static methods can be called without creating objects");
  }

  // Public method
  public void myPublicMethod() {
    System.out.println("Public methods must be called by creating objects");
  }

  // Main method
  public static void main(String[] args) {
    myStaticMethod(); // Call the static method
    // myPublicMethod(); This would compile an error

    Main myObj = new Main(); // Create an object of Main
    myObj.myPublicMethod(); // Call the public method on the object
  }

}


// Access Methods With an Object
// Example:

// Create a Main class
public class Main {
 
  // Create a fullThrottle() method
  public void fullThrottle() {
    System.out.println("The car is going as fast as it can!");
  }

  // Create a speed() method and add a parameter
  public void speed(int maxSpeed) {
    System.out.println("Max speed is: " + maxSpeed);
  }

  // Inside main, call the methods on the myCar object
  public static void main(String[] args) {
    Main myCar = new Main();   // Create a myCar object
    myCar.fullThrottle();      // Call the fullThrottle() method
    myCar.speed(200);          // Call the speed() method
  }
}

// The car is going as fast as it can!
// Max speed is: 200

// Explanation:
// 1) We created a custom Main class with the class keyword.
// 2) We created the fullThrottle() and speed() methods in the Main class.
// 3) The fullThrottle() method and the speed() method will print out some text, when they are called.
// 4) The speed() method accepts an int parameter called maxSpeed - we will use this in 8).
// 5) In order to use the Main class and its methods, we need to create an object of the Main Class.
// 6) Then, go to the main() method, which you know by now is a built-in Java method that runs your program (any code inside main is executed).
// 7) By using the new keyword we created an object with the name myCar.
// 8) Then, we call the fullThrottle() and speed() methods on the myCar object, and run the program using the name of the object (myCar),
//    followed by a dot (.), followed by the name of the method (fullThrottle(); and speed(200);). Notice that we add an int parameter of 200 inside the speed() method.

// Remember that..
// The dot (.) is used to access the object's ATTRIBUTES and METHODS.
// To call a method in Java, write the method name followed by a set of parentheses (), followed by a semicolon (;).
// A class must have a matching filename (Main and Main.java).


// Using Multiple Classes
// Like we specified in the Classes chapter, it is a good practice to create an object of a class and access it in another class.
// Remember that the name of the java file should match the class name. In this example, we have created two files in the same directory:
// Main.java
public class Main {

  public void fullThrottle() {
    System.out.println("The car is going as fast as it can!");
  }

  public void speed(int maxSpeed) {
    System.out.println("Max speed is: " + maxSpeed);
  }

}
// Second.java
class Second {

  public static void main(String[] args) {

    Main myCar = new Main();     // Create a myCar object
    myCar.fullThrottle();      // Call the fullThrottle() method
    myCar.speed(200);          // Call the speed() method

  }
}

// When both files have been compiled, run the Second.java file, and the output will be:
// The car is going as fast as it can!
// Max speed is: 200

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Constructors
// A "constructor" in Java is a special method that is used to initialize objects. The constructor is called when
// an object of a class is created. It can be used to set initial values for object attributes:
public class Main {
  int x;  // Create a class attribute

  // Create a class constructor for the Main class
  public Main() {
    x = 5;  // Set the initial value for the class attribute x
  }

  public static void main(String[] args) {
    Main myObj = new Main(); // Create an object of class Main, the constructor (THIS WILL CALL THE CONSTRUCTOR)
    System.out.println(myObj.x); // Print the value of x
  }
}
// Outputs 5

// Note that the constructor name must match the class name, and it cannot have a return type (like void).
// Also note that the constructor is called when the object is created.
// All classes have constructors by default: if you do not create a class constructor yourself, Java creates one for you.
// However, then you are not able to set initial values for object attributes.


// Constructor Parameters
// Constructors can also take parameters, which is used to initialize attributes.
// The following example adds an int y parameter to the constructor. Inside the constructor we set x to y (x=y).
// When we call the constructor, we pass a parameter to the constructor (5), which will set the value of x to 5:
public class Main {
  int x;

  public Main(int y) {
    x = y;
  } 

  public static void main(String[] args) {
    Main myObj = new Main(5); // here, the number 5 is an argument from the object to the constructor
    System.out.println(myObj.x);
  }
}
// Outputs 5

// You can have as many parameters as you want:
public class Main {
  int modelYear;
  String modelName;

  public Main(int year, String name) {
    modelYear = year;
    modelName = name;
  }

  public static void main(String[] args) {
    Main myCar = new Main(1969, "Mustang");
    System.out.println(myCar.modelYear + " " + myCar.modelName);
  }
}
// Outputs 1969 Mustang

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Modifiers
// By now, you are quite familiar with the "public" keyword that appears in almost all of our examples.
// The "public" keyword is an ACCESS MODIFIER, meaning that it is used to set the ACCESS LEVEL for classes, attributes, methods and constructors.

// We divide modifiers into two groups:
// 1) Access Modifiers - controls the access level
// 2) Non-Access Modifiers - do not control access level, but provides other functionality


// Access Modifiers
// For CLASSES, you can use either public or default:
// 1) public	- The class is accessible by any other class	
// 2) default	- The class is only accessible by classes in the same package. This is used when you don't specify a modifier.
//              You will learn more about packages in the Packages chapter/

// For ATTRIBUTES, METHODS, and CONSTRUCTORS, you can use the one of the following:
// public	    - The code is accessible for all classes	
// private    - The code is only accessible within the declared class	
// default	  - The code is only accessible in the same package. This is used when you don't specify a modifier.
//              You will learn more about packages in the Packages chapter.
// protected  - The code is accessible in the same package and subclasses.
//              You will learn more about subclasses and superclasses in the Inheritance chapter.


// Non-Access Modifiers
// For CLASSES, you can use either final or abstract:
// final    - The class cannot be inherited by other classes (You will learn more about inheritance in the Inheritance chapter)	
// abstract - The class cannot be used to create objects (To access an abstract class, it must be inherited from another class.
//            You will learn more about inheritance and abstraction in the Inheritance and Abstraction chapters)	

// For ATTRIBUTES and METHODS, you can use the one of the following:
// final        - Attributes and methods cannot be overridden/modified
// static       - Attributes and methods belongs to the class, rather than an object
// abstract     - Can only be used in an abstract class, and can only be used on methods.
//                The method does not have a body, for example abstract void run();. The body is provided by the subclass (inherited from).
//                You will learn more about inheritance and abstraction in the Inheritance and Abstraction chapters
// transient    - Attributes and methods are skipped when serializing the object containing them
// synchronized - Methods can only be accessed by one thread at a time
// volatile     - The value of an attribute is not cached thread-locally, and is always read from the "main memory"


// final
// If you don't want the ability to override existing attribute values, declare attributes as final:
public class Main {
  final int x = 10;
  final double PI = 3.14;

  public static void main(String[] args) {
    Main myObj = new Main();
    myObj.x = 50; // will generate an error: cannot assign a value to a final variable
    myObj.PI = 25; // will generate an error: cannot assign a value to a final variable
    System.out.println(myObj.x);
  }
}
// Outputs 10

// static
// A static method means that it can be accessed without creating an object of the class, unlike public:
public class Main {
  // Static method
  static void myStaticMethod() {
    System.out.println("Static methods can be called without creating objects");
  }

  // Public method
  public void myPublicMethod() {
    System.out.println("Public methods must be called by creating objects");
  }

  // Main method
  public static void main(String[ ] args) {
    myStaticMethod(); // Call the static method
    // myPublicMethod(); This would output an error

    Main myObj = new Main(); // Create an object of Main
    myObj.myPublicMethod(); // Call the public method
  }
}

// abstract
// An abstract method belongs to an abstract class, and it does not have a body. The body is provided by the subclass:

// Code from filename: Main.java
// abstract class
abstract class Main {
  public String fname = "John";
  public int age = 24;
  public abstract void study(); // abstract method
}

// Subclass (inherit from Main)
class Student extends Main {
  public int graduationYear = 2018;
  public void study() { // the body of the abstract method is provided here
    System.out.println("Studying all day long");
  }
}
// End code from filename: Main.java

// Code from filename: Second.java
class Second {
  public static void main(String[] args) {
    // create an object of the Student class (which inherits attributes and methods from Main)
    Student myObj = new Student();

    System.out.println("Name: " + myObj.fname);
    System.out.println("Age: " + myObj.age);
    System.out.println("Graduation Year: " + myObj.graduationYear);
    myObj.study(); // call abstract method
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Encapsulation
// The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. To achieve this, you must:
// 1) declare class variables/attributes as private
// 2) provide public "get" and "set" methods to access and update the value of a private variable


// Get and Set
// The get method returns the variable value, and the set method sets the value.
// Syntax for both is that they start with either get or set, followed by the name of the variable, with the first letter in upper case:
// Example:
public class Person {

  private String name; // private = restricted access

  // Getter
  public String getName() {
    return name;
  }

  // Setter
  public void setName(String newName) {
    this.name = newName;  // The this keyword is used to refer to the current object.
  }

}

public class Main {

  public static void main(String[] args) {

    Person myObj = new Person();
    myObj.setName("John"); // Set the value of the name variable to "John"
    System.out.println(myObj.getName());

  }f

}
// Outputs "John"

// Why Encapsulation?
// 1) Better control of class attributes and methods
// 2) Class attributes can be made "read-only" (if you only use the get method), or "write-only" (if you only use the set method)
// 3) Flexible: the programmer can change one part of the code without affecting other parts
// 4) Increased security of data

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Packages
// Java Packages & API
// A package in Java is used to group related classes. Think of it as a folder in a file directory.
// API - acronym for Application Programming Interface, which is a software intermediary that allows two applications to talk to each other.

// We use packages to avoid name conflicts, and to write a better maintainable code. Packages are divided into two categories:
// 1) Built-in Packages (packages from the Java API)
// 2) User-defined Packages (create your own packages)

// Built-in Packages
// The Java API is a library of prewritten classes, that are free to use, included in the Java Development Environment.
// The library contains components for managing input, database programming, and much much more.
// The complete list can be found at Oracles website: https://docs.oracle.com/javase/8/docs/api/.
// The library is divided into packages and classes. Meaning you can either import a single class (along with its methods and attributes),
// or a whole package that contain all the classes that belong to the specified package.

// To use a class or a package from the library, you need to use the import keyword:
// Syntax:
// import package.name.Class;   // Import a single class
// import package.name.*;   // Import the whole package

// If you find a class you want to use, for example, the Scanner class, which is used to get user input, write the following code:
// import java.util.Scanner;

// In the example above, java.util is a "package", while Scanner is a class of the java.util package.
// To use the Scanner class, create an object of the class and use any of the available methods found in the Scanner class documentation.

// In our example, we will use the nextLine() method, which is used to read a complete line:

// import java.util.Scanner;

class MyClass {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in); // the Argument passed is "System.in" - This is the standard input stream
//                                             that is used to read characters from the keyboard or any other standard input device
    System.out.println("Enter username");

    String userName = myObj.nextLine();
    System.out.println("Username is: " + userName);
  }
}


// Import a Package
// There are many packages to choose from. In the previous example, we used the Scanner class from the "java.util" package.
// This package also contains date and time facilities, random-number generator and other utility classes.

// To import a "whole package", end the sentence with an asterisk sign (*). The following example will import ALL the classes in the java.util package:
// import java.util.*;


// User-defined Packages
// To create your own package, you need to understand that Java uses a file system directory to store them. Just like folders on your computer.

// To create a package, use the package keyword:
// package mypack;

class MyPackageClass {
  public static void main(String[] args) {
    System.out.println("This is my package!");
  }
}

// Save the file as MyPackageClass.java, and compile it:
// C:\Users\Your Name>javac MyPackageClass.java

// Then compile the package:
// C:\Users\Your Name>javac -d . MyPackageClass.java

// This forces the compiler to create the "mypack" package.
// The -d keyword specifies the destination for where to save the class file. You can use any directory name,
// like c:/user (windows), or, if you want to keep the package within the same directory, you can use the dot sign ".", like in the example above.
// Note: The package name should be written in lower case to avoid conflict with class names.

// When we compiled the package in the example above, a new folder was created, called "mypack".
// To run the MyPackageClass.java file, write the following:
// C:\Users\Your Name>java mypack.MyPackageClass

// The output will be:
// This is my package!

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Inheritance
// Java Inheritance (Subclass and Superclass)
// In Java, it is possible to inherit attributes and methods from one class to another. We group the "inheritance concept" into two categories:
// 1) subclass (child) - the class that inherits from another class. Class where the "extends" keyword can be found.
// 2) superclass (parent) - the class being inherited from

// To inherit from a class, use the "extends" keyword.

// In the example below, the Car class (subclass) inherits the attributes and methods from the Vehicle class (superclass):
class Vehicle {
  protected String brand = "Ford";        // Vehicle attribute
  public void honk() {                    // Vehicle method
    System.out.println("Tuut, tuut!");
  }
}

class Car extends Vehicle {
  private String modelName = "Mustang";    // Car attribute
  public static void main(String[] args) {

    // Create a myCar object
    Car myCar = new Car();

    // Call the honk() method (from the Vehicle class) on the myCar object
    myCar.honk();

    // Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class
    System.out.println(myCar.brand + " " + myCar.modelName);
  }
}
 
// Did you notice the "protected" modifier in Vehicle?
// We set the brand attribute in Vehicle to a "protected" access modifier. If it was set to private, the Car class would not be able to access it.
// Remember: protected modifier  - The code is accessible in the same "package" and "subclasses".

// Why And When To Use "Inheritance"?
// - It is useful for code reusability: reuse attributes and methods of an existing class when you create a new class.

// Tip: Also take a look at the next chapter, Polymorphism, which uses inherited methods to perform different tasks.
// Tip: If you don't want other classes to inherit from a class, use the "final" keyword.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Polymorphism
// Java Polymorphism
// Polymorphism means "many forms", and it occurs when we have many classes that are related to each other by inheritance.
// Like we specified in the previous chapter; Inheritance lets us inherit attributes and methods from another class.
// Polymorphism uses those methods to perform different tasks. This allows us to perform a single action in different ways.

// For example, think of a superclass called Animal that has a method called animalSound(). Subclasses of Animals could be Pigs, Cats, Dogs, Birds,
// and they also have their own implementation of an animal sound (the pig oinks, and the cat meows, etc.):
class Animal {
  public void animalSound() {
    System.out.println("The animal makes a sound");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
}

class Dog extends Animal {
  public void animalSound() {
    System.out.println("The dog says: bow wow");
  }
}


// Now we can create Pig and Dog objects and call the animalSound() method on both of them:
class Animal {
  public void animalSound() {
    System.out.println("The animal makes a sound");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
}

class Dog extends Animal {
  public void animalSound() {
    System.out.println("The dog says: bow wow");
  }
}

class Main {
  public static void main(String[] args) {
    Animal myAnimal = new Animal();  // Create a Animal object
    Animal myPig = new Pig();  // Create a Pig object
    Animal myDog = new Dog();  // Create a Dog object
    myAnimal.animalSound();
    myPig.animalSound();
    myDog.animalSound();
  }
}
// Output:
// The animal makes a sound
// The pig says: wee wee
// The dog says: bow wow


// Basically, Inheritance lets you access a class' attributes and methods, and Polymorphism enables you to perform tasks using those.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Inner Classes
// Java Inner Classes
// In Java, it is also possible to nest classes (a class within a class). The purpose of nested classes is to
// group classes that belong together, which makes your code more readable and maintainable.

// To access the inner class, create an object of the outer class, and then create an object of the inner class:
class OuterClass {
  int x = 10;

  class InnerClass {
    int y = 5;
  }
}

public class Main {
  public static void main(String[] args) {
    OuterClass myOuter = new OuterClass();
    OuterClass.InnerClass myInner = myOuter.new InnerClass();
    System.out.println(myInner.y + myOuter.x);
  }
}
// Outputs 15 (5 + 10)


// Private Inner Class
// Unlike a "regular" class, an inner class can be private or protected. If you don't want outside objects to access the inner class,
// declare the class as private:
class OuterClass {
  int x = 10;

  private class InnerClass {
    int y = 5;
  }
}

public class Main {
  public static void main(String[] args) {
    OuterClass myOuter = new OuterClass();
    OuterClass.InnerClass myInner = myOuter.new InnerClass();
    System.out.println(myInner.y + myOuter.x);
  }
}
// An error will occur in this ^


// Static Inner Class
// An inner class can also be static, which means that you can access it without creating an object of the outer class:
class OuterClass {
  int x = 10;

  static class InnerClass {
    int y = 5;
  }
}

public class Main {
  public static void main(String[] args) {
    OuterClass.InnerClass myInner = new OuterClass.InnerClass();
    System.out.println(myInner.y);
  }
}
// Outputs 5

// Note: just like static attributes and methods, a static inner class does not have access to members of the outer class.


// Access Outer Class From Inner Class
// One advantage of inner classes, is that they can access attributes and methods of the outer class:
class OuterClass {
  int x = 10;

  class InnerClass {
    public int myInnerMethod() {
      return x;
    }
  }
}

public class Main {
  public static void main(String[] args) {
    OuterClass myOuter = new OuterClass();
    OuterClass.InnerClass myInner = myOuter.new InnerClass();
    System.out.println(myInner.myInnerMethod());
  }
}
// Outputs 10

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Abstraction
// Abstract Classes and Methods
// Data abstraction is the process of hiding certain details and showing only essential information to the user.
// Abstraction can be achieved with either abstract classes or interfaces (which you will learn more about in the next chapter).

// The "abstract" keyword is a non-access modifier, used for classes and methods:
// 1) Abstract class: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).
// 2) Abstract method: can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).

// An abstract class can have both abstract and regular methods:
abstract class Animal {
  public abstract void animalSound();
  public void sleep() {
    System.out.println("Zzz");
  }
}

// From the example above, it is not possible to create an object of the Animal class:
Animal myObj = new Animal(); // will generate an error

// To access the abstract class, it must be inherited from another class. Let's convert the Animal class
// we used in the Polymorphism chapter to an abstract class:
// Remember from the Inheritance chapter that we use the extends keyword to inherit from a class.

// Abstract class
abstract class Animal {
  // Abstract method (does not have a body)
  public abstract void animalSound();
  // Regular method
  public void sleep() {
    System.out.println("Zzz");
  }
}

// Subclass (inherit from Animal)
class Pig extends Animal {
  public void animalSound() {
    // The body of animalSound() is provided here
    System.out.println("The pig says: wee wee");
  }
}

class Main {
  public static void main(String[] args) {
    Pig myPig = new Pig(); // Create a Pig object
    myPig.animalSound();
    myPig.sleep();
  }
}

// Why And When To Use Abstract Classes and Methods?
// To achieve security - hide certain details and only show the important details of an object.

// Note: Abstraction can also be achieved with Interfaces, which you will learn more about in the next chapter.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Interface
// Interfaces
// Another way to achieve abstraction in Java, is with interfaces.
// An interface is a completely "abstract class" that is used to group related methods with empty bodies:
interface Animal {
  public void animalSound(); // interface method (does not have a body)
  public void run(); // interface method (does not have a body)
}


// To access the interface methods, the interface must be "implemented" (kinda like inherited) by another class
// with the "implements" keyword (instead of "extends"). The body of the interface method is provided by the "implement" class:
interface Animal {
  public void animalSound(); // interface method (does not have a body)
  public void sleep(); // interface method (does not have a body)
}

// Pig "implements" the Animal interface
class Pig implements Animal {
  public void animalSound() {
    // The body of animalSound() is provided here
    System.out.println("The pig says: wee wee");
  }
  public void sleep() {
    // The body of sleep() is provided here
    System.out.println("Zzz");
  }
}

class Main {
  public static void main(String[] args) {
    Pig myPig = new Pig();  // Create a Pig object
    myPig.animalSound();
    myPig.sleep();
  }
}


// Notes on Interfaces:
// 1) Like abstract classes, interfaces cannot be used to create objects (in the example above, it is not possible to create
//    an "Animal" object in the MyMainClass)
// 2) Interface methods do not have a body - the body is provided by the "implement" class
// 3) On implementation of an interface, you must override all of its methods
// 4) Interface methods are by default abstract and public
// 5) Interface attributes are by default public, static and final
// 6) An interface cannot contain a constructor (as it cannot be used to create objects)

// Why And When To Use Interfaces?
// 1) To achieve security - hide certain details and only show the important details of an object (interface).
// 2) Java does not support "multiple inheritance" (a class can only inherit from one superclass). However, it can be achieved with interfaces,
//    because the class can implement multiple interfaces. Note: To implement multiple interfaces, separate them with a comma (see example below):

interface FirstInterface {
  public void myMethod(); // interface method
}

interface SecondInterface {
  public void myOtherMethod(); // interface method
}

class DemoClass implements FirstInterface, SecondInterface {
  public void myMethod() {
    System.out.println("Some text..");
  }
  public void myOtherMethod() {
    System.out.println("Some other text...");
  }
}

class Main {
  public static void main(String[] args) {
    DemoClass myObj = new DemoClass();
    myObj.myMethod();
    myObj.myOtherMethod();
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Enums
// Enums
// An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).

// To create an enum, use the enum keyword (instead of class or interface), and separate the constants with a comma. Note that they should be in uppercase letters:
enum Level {  
  LOW,
  MEDIUM,
  HIGH
}

// You can access enum constants with the dot syntax:
evel myVar = Level.MEDIUM;

// Enum is short for "enumerations", which means "specifically listed".


// Enum inside a Class
public class Main {
  enum Level {
    LOW,
    MEDIUM,
    HIGH
  }

  public static void main(String[] args) {
    Level myVar = Level.MEDIUM; 
    System.out.println(myVar);
  }
}


// Enum in a Switch Statement
// Enums are often used in switch statements to check for corresponding values:
enum Level {
  LOW,
  MEDIUM,
  HIGH
}

public class Main {
  public static void main(String[] args) {
    Level myVar = Level.MEDIUM;

    switch(myVar) {
      case LOW:
        System.out.println("Low level");
        break;
      case MEDIUM:
         System.out.println("Medium level");
        break;
      case HIGH:
        System.out.println("High level");
        break;
    }
  }
}


// Loop Through an Enum
// The enum type has a values() method, which returns an array of all enum constants. This method is useful when
// you want to loop through the constants of an enum:
for (Level myVar : Level.values()) {
  System.out.println(myVar);
}

// Output will be:
// LOW
// MEDIUM
// HIGH


// Difference between Enums and Classes
// An enum can, just like a class, have attributes and methods. The only difference is that enum constants are public,
// static and final (unchangeable - cannot be overridden).

// An enum cannot be used to create objects, and it cannot extend other classes (but it can implement interfaces).

// Why And When To Use Enums?
// Use enums when you have values that you know aren't going to change, like month days, days, colors, deck of cards, etc.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java User Input
// The Scanner class is used to get user input, and it is found in the java.util package.

// To use the Scanner class, create an object of the class and use any of the available methods found in the Scanner class documentation.
// In our example, we will use the nextLine() method, which is used to read Strings:

// import java.util.Scanner;  // Import the Scanner class

class Main {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter username");

    String userName = myObj.nextLine();  // Read user input
    System.out.println("Username is: " + userName);  // Output user input
  }
}


// Input Types
// In the example above, we used the nextLine() method, which is used to read Strings. To read other types, look at the table below:

// nextBoolean()  - Reads a boolean value from the user
// nextByte()     - Reads a byte value from the user
// nextDouble()   - Reads a double value from the user
// nextFloat()    - Reads a float value from the user
// nextInt()      - Reads a int value from the user
// nextLine()     - Reads a String value from the user
// nextLong()     - Reads a long value from the user
// nextShort()    - Reads a short value from the user


// In the example below, we use different methods to read data of various types:

// import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);

    System.out.println("Enter name, age and salary:");

    // String input
    String name = myObj.nextLine();

    // Numerical input
    int age = myObj.nextInt();
    double salary = myObj.nextDouble();

    // Output input by user
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Salary: " + salary);
  }
}

// Note: If you enter wrong input (e.g. text in a numerical input), you will get an exception/error message (like "InputMismatchException").

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Date and Time
// Java Dates
// Java does not have a built-in Date class, but we can import the java.time package to work with the date and time API.
// The package includes many date and time classes. For example:

// Class	              Description
// LocalDate	          Represents a date (year, month, day (yyyy-MM-dd))
// LocalTime	          Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns))
// LocalDateTime	      Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
// DateTimeFormatter	  Formatter for displaying and parsing date-time objects


// Display Current Date
// To display the current date, import the java.time.LocalDate class, and use its now() method:

// import java.time.LocalDate; // import the LocalDate class

public class Main {
  public static void main(String[] args) {
    LocalDate myObj = LocalDate.now(); // Create a date object
    System.out.println(myObj); // Display the current date
  }
}
// Output: 2021-12-27


// Display Current Time
// To display the current time (hour, minute, second, and nanoseconds), import the java.time.LocalTime class, and use its now() method:

// import java.time.LocalTime; // import the LocalTime class

public class Main {
  public static void main(String[] args) {
    LocalTime myObj = LocalTime.now();
    System.out.println(myObj);
  }
}
// Output: 18:32:57.195544


// Display Current Date and Time
// To display the current date and time, import the java.time.LocalDateTime class, and use its now() method:

// import java.time.LocalDateTime; // import the LocalDateTime class

public class Main {
  public static void main(String[] args) {
    LocalDateTime myObj = LocalDateTime.now();
    System.out.println(myObj);
  }
}
// Output: 2021-12-27T18:32:57.209603


// Formatting Date and Time
// The "T" in the example above is used to separate the date from the time. You can use the "DateTimeFormatter" class
// with the ofPattern() method in the same package to format or parse date-time objects.
// The following example will remove both the "T" and nanoseconds from the date-time:

// import java.time.LocalDateTime; // Import the LocalDateTime class
// import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Main {
  public static void main(String[] args) {
    LocalDateTime myDateObj = LocalDateTime.now();
    System.out.println("Before formatting: " + myDateObj);

    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    String formattedDate = myDateObj.format(myFormatObj);
    System.out.println("After formatting: " + formattedDate);
  }
}

// The output will be:
// Before Formatting: 2021-12-27T18:32:57.209904
// After Formatting: 27-12-2021 18:32:57


// The ofPattern() method accepts all sorts of values, if you want to display the date and time in a different format. For example:
// Value	            Example	
// yyyy-MM-dd	        "1988-09-29"	
// dd/MM/yyyy	        "29/09/1988"	
// dd-MMM-yyyy	      "29-Sep-1988"	
// E, MMM dd yyyy	    "Thu, Sep 29 1988"    - "E" is the day of the week

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java ArrayList
// The ArrayList class is a resizable array, which can be found in the java.util package.
// The difference between a built-in array and an ArrayList in Java, is that the size of an array cannot be modified
// (if you want to add or remove elements to/from an array, you have to create a new one). While elements can be added and
// removed from an ArrayList whenever you want. The syntax is also slightly different:

// Example:
// Create an ArrayList object called cars that will store strings:

// import java.util.ArrayList; // import the ArrayList class

ArrayList<String> cars = new ArrayList<String>(); // Create an ArrayList object


// Add Items
// The ArrayList class has many useful methods. For example, to add elements to the ArrayList, use the add() method:

// import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {

    ArrayList<String> cars = new ArrayList<String>();

    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);
  }

}
// Output: [Volvo, BMW, Ford, Mazda]


// Access an Item
// To access an element in the ArrayList, use the get() method and refer to the index number:
cars.get(0);


// Change an Item
// To modify an element, use the set() method and refer to the index number:
cars.set(0, "Opel");


// Remove an Item
// To remove an element, use the remove() method and refer to the index number:
cars.remove(0);


// To remove all the elements in the ArrayList, use the clear() method:
cars.clear();


// ArrayList Size
// To find out how many elements an ArrayList have, use the size method:
cars.size();


// Loop Through an ArrayList
// Loop through the elements of an ArrayList with a for loop, and use the size() method to specify how many times the loop should run:
public class Main {

  public static void main(String[] args) {

    ArrayList<String> cars = new ArrayList<String>();

    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");

    for (int i = 0; i < cars.size(); i++) {
      System.out.println(cars.get(i));
    }

  }

}


// You can also loop through an ArrayList with the for-each loop:
public class Main {

  public static void main(String[] args) {

    ArrayList<String> cars = new ArrayList<String>();

    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");

    for (String i : cars) {
      System.out.println(i);
    }

  }

}


// Other Types
// Elements in an ArrayList are actually objects. In the examples above, we created elements (objects) of type "String".
// Remember that a String in Java is an object (not a primitive type). To use other types, such as int, you must specify an
// equivalent "wrapper class": Integer. For other primitive types, use: Boolean for boolean, Character for char, Double for double, etc:
// wrapper class - it's what's inside the < >, String, Integer, Boolean, etc.

// Example:
// Create an ArrayList to store numbers (add elements of type Integer):

// import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {

    ArrayList<Integer> myNumbers = new ArrayList<Integer>();

    myNumbers.add(10);
    myNumbers.add(15);
    myNumbers.add(20);
    myNumbers.add(25);

    for (int i : myNumbers) {
      System.out.println(i);
    }

  }

}


// Sort an ArrayList
// Another useful class in the java.util package is the "Collections" class, which include the sort() method for sorting lists alphabetically or numerically.


// Example:
// Sort an ArrayList of Strings

// import java.util.ArrayList;
// import java.util.Collections;  // Import the Collections class

public class Main {

  public static void main(String[] args) {

    ArrayList<String> cars = new ArrayList<String>();
    
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");

    Collections.sort(cars);  // Sort cars

    for (String i : cars) {
      System.out.println(i);
    }

  }

}
// Output: 
// BMW
// Ford
// Mazda
// Volvo


// Example:
// Sort an ArrayList of Integers:

// import java.util.ArrayList;
// import java.util.Collections;  // Import the Collections class

public class Main {

  public static void main(String[] args) {

    ArrayList<Integer> myNumbers = new ArrayList<Integer>();

    myNumbers.add(33);
    myNumbers.add(15);
    myNumbers.add(20);
    myNumbers.add(34);
    myNumbers.add(8);
    myNumbers.add(12);

    Collections.sort(myNumbers);  // Sort myNumbers

    for (int i : myNumbers) {
      System.out.println(i);
    }

  }

}
// Output:
// 8
// 12
// 15
// 20
// 33
// 34

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java LinkedList
// The LinkedList class is almost identical to the ArrayList:
// Example:

// Import the LinkedList class
// import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {

    LinkedList<String> cars = new LinkedList<String>();

    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");

    System.out.println(cars);
  }
}

// ArrayList vs. LinkedList
// The LinkedList class is a collection which can contain many objects of the same type, just like the ArrayList.
// The LinkedList class has all of the same methods as the ArrayList class because they both implement the List interface.
// This means that you can add items, change items, remove items and clear the list in the same way.
// However, while the ArrayList class and the LinkedList class can be used in the same way, they are built very differently.

// How the ArrayList works
// The ArrayList class has a regular array inside it. When an element is added, it is placed into the array. If the array is not big enough,
// a new, larger array is created to replace the old one and the old one is removed.

// How the LinkedList works
// The LinkedList stores its items in "containers." The list has a link to the first container and each container has a link to the next container in the list.
// To add an element to the list, the element is placed into a new container and that container is linked to one of the other containers in the list.

// When To Use
// Use an ArrayList for storing and accessing data, and LinkedList to manipulate data.

// LinkedList Methods
// For many cases, the ArrayList is more efficient as it is common to need access to random items in the list,
// but the LinkedList provides several methods to do certain operations more efficiently:
// Method	         Description
// addFirst()     - Adds an item to the beginning of the list.	
// addLast()      - Add an item to the end of the list	
// removeFirst()  - Remove an item from the beginning of the list.	
// removeLast()   - Remove an item from the end of the list	
// getFirst()     - Get the item at the beginning of the list	
// getLast()      - Get the item at the end of the list

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java HashMap
// In the ArrayList chapter, you learned that Arrays store items as an ordered collection, and you have to access them with an index number (int type).
// A HashMap however, store items in "key/value" pairs, and you can access them by an index of another type (e.g. a String).

// One object is used as a key (index) to another object (value). It can store different types:
// String keys and Integer values, or the same type, like: String keys and String values:

// Example:
// Create a HashMap object called capitalCities that will store String keys and String values:

//import java.util.HashMap; // import the HashMap class

HashMap<String, String> capitalCities = new HashMap<String, String>();

// Add Items
// The HashMap class has many useful methods. For example, to add items to it, use the put() method:

// Import the HashMap class
// import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    // Create a HashMap object called capitalCities
    HashMap<String, String> capitalCities = new HashMap<String, String>();

    // Add keys and values (Country, City)
    capitalCities.put("England", "London");   // England is key, London is value
    capitalCities.put("Germany", "Berlin");
    capitalCities.put("Norway", "Oslo");
    capitalCities.put("USA", "Washington DC");
    System.out.println(capitalCities);
  }
}


// Access an Item
// To access a value in the HashMap, use the get() method and refer to its key:
capitalCities.get("England");   // England is key


// Remove an Item
// To remove an item, use the remove() method and refer to the key:
capitalCities.remove("England");


// To remove all items, use the clear() method:
capitalCities.clear();


// HashMap Size
// To find out how many items there are, use the size() method:
capitalCities.size();


// Loop Through a HashMap
// Loop through the items of a HashMap with a for-each loop.

// Note: Use the keySet() method if you only want the keys, and use the values() method if you only want the values:
for (String i : capitalCities.keySet()) {
  System.out.println(i);
}
// Prints all "keys" in the HashMap

for (String i : capitalCities.values()) {
  System.out.println(i);
}
// Prints all values in the HashMap


// To print both keys and values, refer to the example below:
for (String i : capitalCities.keySet()) {
  System.out.println("key: " + i + " value: " + capitalCities.get(i));
}


// Other Types
// Keys and values in a HashMap are actually objects. In the examples above, we used objects of type "String". Remember that
// a String in Java is an object (not a primitive type). To use other types, such as int, you must specify an equivalent wrapper class: Integer.
// For other primitive types, use: Boolean for boolean, Character for char, Double for double, etc:

// import java.util.HashMap;

public class Main {
  public static void main(String[] args) {

    // Create a HashMap object called people
    HashMap<String, Integer> people = new HashMap<String, Integer>();


    // Add keys and values (Name, Age)
    people.put("John", 32);
    people.put("Steve", 30);
    people.put("Angie", 33);

    for (String i : people.keySet()) {
      System.out.println("key: " + i + " value: " + people.get(i));
    }
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java HashSet
// A HashSet is a collection of items where every item is unique, and it is found in the java.util package:

// Example:
// Create a HashSet object called cars that will store strings:

// import java.util.HashSet; // Import the HashSet class

HashSet<String> cars = new HashSet<String>();


// Add Items
// The HashSet class has many useful methods. For example, to add items to it, use the add() method:

// Example:

// import java.util.HashSet;

public class Main {
  public static void main(String[] args) {
    HashSet<String> cars = new HashSet<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("BMW");
    cars.add("Mazda");
    System.out.println(cars);
  }
}


// Check If an Item Exists
// To check whether an item exists in a HashSet, use the contains() method:
cars.contains("Mazda");


// Remove an Item
// To remove an item, use the remove() method:
cars.remove("Volvo");


// To remove all items, use the clear() method:
cars.clear();


// HashSet Size
// To find out how many items there are, use the size method:
cars.size();


// Loop Through a HashSet
// Loop through the items of an HashSet with a for-each loop:
for (String i : cars) {
  System.out.println(i);
}


// Other Types
// Items in an HashSet are actually objects. In the examples above, we created items (objects) of type "String". Remember that
// a String in Java is an object (not a primitive type). To use other types, such as int, you must specify an equivalent wrapper class: Integer.
// For other primitive types, use: Boolean for boolean, Character for char, Double for double, etc:

// Example
// Use a HashSet that stores Integer objects:

// import java.util.HashSet;

public class Main {
  public static void main(String[] args) {

    // Create a HashSet object called numbers
    HashSet<Integer> numbers = new HashSet<Integer>();

    // Add values to the set
    numbers.add(4);
    numbers.add(7);
    numbers.add(8);

    // Show which numbers between 1 and 10 are in the set
    for(int i = 1; i <= 10; i++) {
      if(numbers.contains(i)) {
        System.out.println(i + " was found in the set.");
      } else {
        System.out.println(i + " was not found in the set.");
      }
    }
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Iterator
// An Iterator is an object that can be used to loop through collections, like ArrayList and HashSet. It is called an "iterator"
// because "iterating" is the technical term for looping.

// To use an Iterator, you must import it from the java.util package.
// import java.util.Iterator;


// Getting an Iterator
// The iterator() method can be used to get an Iterator for any collection:

// Example
// Import the ArrayList class and the Iterator class

// import java.util.ArrayList;
// import java.util.Iterator;

public class Main {
  public static void main(String[] args) {

    // Make a collection
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");

    // Get the iterator
    Iterator<String> it = cars.iterator();

    // Print the first item
    System.out.println(it.next());
  }
}


// Looping Through a Collection
// To loop through a collection, use the hasNext() and next() methods of the Iterator:
while(it.hasNext()) {
  System.out.println(it.next());
}


// Removing Items from a Collection
// Iterators are designed to easily change the collections that they loop through. The remove() method
// can remove items from a collection while looping.

// Example
// Use an iterator to remove numbers less than 10 from a collection:

// import java.util.ArrayList;
// import java.util.Iterator;

public class Main {
  public static void main(String[] args) {

    ArrayList<Integer> numbers = new ArrayList<Integer>();

    numbers.add(12);
    numbers.add(8);
    numbers.add(2);
    numbers.add(23);

    Iterator<Integer> it = numbers.iterator();

    while(it.hasNext()) {

      Integer i = it.next();

      if(i < 10) {
        it.remove();
      }

    }

    System.out.println(numbers);
  }
}

// Note: Trying to remove items using a for loop or a for-each loop would not work correctly because the collection
// is changing size at the same time that the code is trying to loop.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Wrapper Classes
// Wrapper classes provide a way to use primitive data types (int, boolean, etc..) as objects.

// The table below shows the primitive type and the equivalent wrapper class:

// Primitive Data Type	      Wrapper Class
// byte	                      Byte
// short	                    Short
// int	                      Integer
// long	                      Long
// float	                    Float
// double	                    Double
// boolean	                  Boolean
// char	                      Character

// Sometimes you must use wrapper classes, for example when working with Collection objects, such as ArrayList,
// where primitive types cannot be used (the list can only store objects):

// Example
ArrayList<int> myNumbers = new ArrayList<int>(); // Invalid
ArrayList<Integer> myNumbers = new ArrayList<Integer>(); // Valid


// Creating Wrapper Objects
// To create a wrapper object, use the wrapper class instead of the primitive type. To get the value, you can just print the object:

// Example
public class Main {
  public static void main(String[] args) {
    Integer myInt = 5;
    Double myDouble = 5.99;
    Character myChar = 'A';
    System.out.println(myInt);
    System.out.println(myDouble);
    System.out.println(myChar);
  }
}
// Output
// 5
// 5.99
// A


// Since you're now working with objects, you can use certain methods to get information about the specific object.

// For example, the following methods are used to get the value associated with the corresponding wrapper object:
// intValue(), byteValue(), shortValue(), longValue(), floatValue(), doubleValue(), charValue(), booleanValue().

// This example will output the same result as the example above:
public class Main {
  public static void main(String[] args) {
    Integer myInt = 5;
    Double myDouble = 5.99;
    Character myChar = 'A';
    System.out.println(myInt.intValue());
    System.out.println(myDouble.doubleValue());
    System.out.println(myChar.charValue());
  }
}
// Output
// 5
// 5.99
// A


// Another useful method is the toString() method, which is used to convert wrapper objects to strings.

// In the following example, we convert an Integer to a String, and use the length() method
// of the String class to output the length of the "string":

// Example
public class Main {
  public static void main(String[] args) {
    Integer myInt = 100;
    String myString = myInt.toString();
    System.out.println(myString.length());
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------- Java Exceptions
// When executing Java code, different errors can occur: coding errors made by the programmer, errors due to wrong input, or other unforeseeable things.
// When an error occurs, Java will normally stop and generate an error message.
// The technical term for this is: Java will throw an exception (throw an error).


// Java try and catch
// The try statement allows you to define a block of code to be tested for errors while it is being executed.
// The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.

// The try and catch keywords come in pairs:

// Syntax
try {
  //  Block of code to try
}
catch(Exception e) {
  //  Block of code to handle errors
}


// Consider the following example:
// This will generate an error, because myNumbers[10] does not exist.

public class Main {
  public static void main(String[ ] args) {
    int[] myNumbers = {1, 2, 3};
    System.out.println(myNumbers[10]); // error!
  }
}
// The output will be something like this:

// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 10
//         at Main.main(Main.java:4)


// If an error occurs, we can use try...catch to catch the error and execute some code to handle it:

// Example:
public class Main {
  public static void main(String[ ] args) {
    try {
      int[] myNumbers = {1, 2, 3};
      System.out.println(myNumbers[10]);
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }
  }
}
// The output will be:
// Something went wrong.


// Finally
// The "finally" statement lets you execute code, after try...catch, regardless of the result:

// Example
public class Main {
  public static void main(String[] args) {
    try {
      int[] myNumbers = {1, 2, 3};
      System.out.println(myNumbers[10]);
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    } finally {
      System.out.println("The 'try catch' is finished.");
    }
  }
}
// The output will be:
// Something went wrong.
// The 'try catch' is finished.


// The throw keyword
// The throw statement allows you to create a custom error.
// The throw statement is used together with an exception type. There are many exception types available in Java:
// ArithmeticException, FileNotFoundException, ArrayIndexOutOfBoundsException, SecurityException, etc:

// Example
// Throw an exception if age is below 18 (print "Access denied"). If age is 18 or older, print "Access granted":
public class Main {
  static void checkAge(int age) {
    if (age < 18) {
      throw new ArithmeticException("Access denied - You must be at least 18 years old.");
    }
    else {
      System.out.println("Access granted - You are old enough!");
    }
  }

  public static void main(String[] args) {
    checkAge(15); // Set age to 15 (which is below 18...)
  }
}
// The output will be:
// Exception in thread "main" java.lang.ArithmeticException: Access denied - You must be at least 18 years old.
//         at Main.checkAge(Main.java:4)
//         at Main.main(Main.java:12)

// If age was 20, you would not get an exception:
// Example
checkAge(20);
//The output will be:
// Access granted - You are old enough!








//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// Instance Initialization Blocks - executes when the constructor is called, but before the execution of the constructor
//                                - unlike a constructor, this block just has a body without any name or visibility type
//                                - EX: { System.out.println("setting field"); }







//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~