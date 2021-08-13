package infixtopostfix;

import java.util.*;

public class infixTopostfix{

    public static boolean isoperand(Character c){
        return Character.isLetterOrDigit(c);
    }
    public static boolean isoperator(Character c){
        return (c=='+'||c=='-'||c=='*'||c=='/'||c=='^');
    }
    public static boolean isomuldiv(Character c){
        return (c=='*' || c== '/');
    }
    public static boolean isplusminus(Character c){
        return (c=='+' || c== '-');
    }
    public static boolean isexp(Character c){
        return (c=='^');
    }
    public static int precedence(Character c){
        if (isexp(c)) return 3;
        else if(isomuldiv(c)) return 2;
        else if(isplusminus(c)) return 1;
        else return 0;
    }

    public static void getPostfix(String x){
        String p = new String("");
        Stack<Character> s = new Stack<>();

        int len = x.length();
        char c;
        for(int i = 0; i<len; i++){
            c = x.charAt(i);
            if(isoperand(c)){
                p+=c;
            }
            else if(isoperator(c)){
                // if(isexp(c)){
                //     s.push(c);
                //     continue;
                // }
                if(s.isEmpty()) s.push(c);
                else{
                    while(s.isEmpty()==false &&  precedence(s.peek())>=precedence(c) )
                    p+=s.pop();
                    s.push(c);
                }
            }
            else if(c=='(') s.push(c);
            else if(c==')'){
                while(s.isEmpty()==false && s.peek()!='(') p+=s.pop();
                if(s.isEmpty()==true){
                    System.out.printf("Invalid Input");
                    return;
                }
                else s.pop();
            }
        }
        while(s.isEmpty()==false)p+=s.pop();
        System.out.printf("%s\n",p);
    }
    

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        String infix = s.next();
        getPostfix(infix);

        
    }

}



