package labfour;

import java.util.Scanner;

class stack{
    static final int max = 1001;
    int top;
    int[] a = new int[max];
    stack(){
        top = -1;
    }
    boolean is_empty(){
        return (top<0);
    }
    boolean is_full(){
        return (top>=max-1);
    }
    boolean push(int x){
        if(is_full()) {
            System.out.println("Stack Overfllow!");
            return false;
        }
        else{
            a[++top] = x;
            return  true;
        }
    }
    int pop(){
        if(is_empty()){
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            return a[top--];
        }
    }
    int peek(){
        if(is_empty()){
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            return a[top];
        }
    }
}

public class Solution2 {

public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    stack st = new stack();
    st.pop();
    st.peek();
    for (int t= 0; t < T; t++){
        st.push(s.nextInt());
    }
    System.out.println("Now popping!");
    for (int t= 0; t < T; t++){
        System.out.println(st.pop());

    }
}


}
