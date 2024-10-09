// Hackerrank 18 - Java Abstract Class

import java.util.*;
abstract class Book{
	String title;
	abstract void setTitle(String s);
	String getTitle(){
		return title;
	}
}

//Write MyBook class here
class MyBook extends Book {
    void setTitle(String s) {
        title = s;  // set value of String title to user input
    }    
}

public class Main{
	
	public static void main(String []args){
		//Book new_novel=new Book(); This line prHMain.java:25: error: Book is abstract; cannot be instantiated
		Scanner sc=new Scanner(System.in);
		String title=sc.nextLine();
		MyBook new_novel=new MyBook();
		new_novel.setTitle(title);
		System.out.println("The title is: "+new_novel.getTitle());
      	sc.close();
		
	}
}

// VERBAL EXPLANATIONS:

// in line 13 we have a MyBook class, and this is a subclass because it extends Book class, so it inherits the attributes and methods from the Book class in the locked portion of the code above.
// in the next line, the body of the abstract setTitle() method is provided here, which will just set the value of the String title to the user input.