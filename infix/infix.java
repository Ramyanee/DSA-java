package infix;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class infix {

    
    static int precedence(char ch)
    {

        if(ch == '+' || ch == '-')return 1;
        else if(ch == '*' || ch == '/')return 2;
        else if(ch == '*' || ch == '/')return 3;
        return 0;
        
    }
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        String infix = s.nextLine();
        //System.out.printf("%s\n",infix);
        String r = new String("");
        
        
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i<infix.length(); i++){
            
            char ch  = infix.charAt(i);
            
            
            if (ch == '(') st.push(ch);
            
            else if(ch == ')'){
                while (st.isEmpty()==false && st.peek() != '(')
                    r += st.pop();
                    st.pop();
            }
            
            
            else if(Character.isLetterOrDigit(ch))
                r += ch;
            
            else{
                while (st.isEmpty()==false && precedence(ch)
                         <= precedence(st.peek())){
                   
                    r += st.pop();
             }
                st.push(ch);
            }
        }
        
        while(st.isEmpty()==false){
            r+=st.pop();
        }
        
        
        
        String postfix = r;
        
        System.out.printf("%s",postfix);
        
        
        
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}