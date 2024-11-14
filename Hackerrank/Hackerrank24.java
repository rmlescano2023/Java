// Hackerrank 24 - Java Singleton Pattern

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;


class Singleton{
    private Singleton() {}
    public String str;
    
    static Singleton myObj;
    
    static Singleton getSingleInstance() {
        if (myObj == null) {
            myObj = new Singleton();
        }
        return myObj;
    }

}

// VERBAL EXPLANATION:

// in line 10, we created the first component of the Singleton class, which is a constructor of the class without parameter, and we also used the
// private modifier since it was required, so that we cannot create an object outside of the class, only inside the Singleton class, because a private
// modifier only allows attributes, methods, or constructors to be accessibke within the same class. It is also important that the constructor must
// match the class name. That is why it was also named Singleton.

// next, in line 11, we created the second component, a public String variable named str.

// skipping this line, we proceed first in line 15 where the third component is created, and here we have a static method named getSingleInstance()
// and inside we should return a single instance of the Singleton class, "myObj", which we created here in line 13 and a return value of object Singleton.
// Inside, we also have a condition that if the value of the object is null or it does not exist, it will create a new Singleton object, assign it to the "myObj"
// object and return it. Then, if the object already exists, it will not go through the if statement, and return the same value as before again and again.
// I also used the static modifier here in the getSingleInstance method so that we can call this method without creating an object.
// I don't know what the contents of the hidden class is, but my code passed all the test cases when I submitted it, so it's probably correct this way.