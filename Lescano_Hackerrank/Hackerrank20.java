// Hackerrank 20 - Java Method Overriding

import java.util.*;
class Sports{

    String getName(){
        return "Generic Sports";
    }
  
    void getNumberOfTeamMembers(){
        System.out.println( "Each team has n players in " + getName() );
    }
}

class Soccer extends Sports{
    @Override
    String getName(){
        return "Soccer Class";
    }

    // Write your overridden getNumberOfTeamMembers method here
    @Override
    void getNumberOfTeamMembers(){
        System.out.println( "Each team has 11 players in " + getName() );   // changed n to 11
    }
    

}

public class Solution{
	
    public static void main(String []args){
        Sports c1 = new Sports();
        Soccer c2 = new Soccer();
        System.out.println(c1.getName());
        c1.getNumberOfTeamMembers();
        System.out.println(c2.getName());
        c2.getNumberOfTeamMembers();
	}
}

// VERBAL EXPLANATION:

// So the process is just pretty straightforward, we just need to precede the overridden method with a @Override annotation, copy and paste the method in the next line, and just
// change n inside the quotation marks into 11. I just copy and pasted the whole method and changed only what was necessary because the parameter(s) and return type of an overridden method
// must be exactly the same as those of the method inherited from the supertype. So it is also important to note to be careful when overriding methods.