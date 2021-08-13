package palindrome;

import java.util.*;

// this program accepts a String (with or without spaces "/s") and 
// prints "true" if it is a palindrome, and "false" if it is not a palindrome.

//****** this is written as insensitive to the case, and presence of white spaces
// in the input string.

// it will return true for strings like:

// mom
// Mom
// moM
// Civic
// was it a car or a cat i saw
// Mr Owl ate my Metal Worm

//****** However, it is not insensitive to the presence of special characters and punctuations.

// for example it will return false for a String like:
// Mr. Owl ate my Metal Worm
// was it a car, or a cat i saw
// palindrome
// anything



public class palindrome {

    public static boolean pal(String p){

        
        p = p.toLowerCase(); // rendering insensitive to case
        p = p.replaceAll("\\s", ""); //rendering insensitive to spacespop

        int l = p.length();

        for(int i = 0; i<l/2; i++){

            if(p.charAt(i)==p.charAt(l-(i+1))) continue;
            else return false;


        }
        return true;


    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String x = s.nextLine();

        System.out.println(x);

        s.close();

        System.out.println(pal(x));


    }
    
}
