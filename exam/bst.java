package exam;

import java.util.ArrayList;
import java.util.Scanner;
class queue{
    int size;
    int front;
    int rear;
    int capacity;
    int a[];
    queue(int capacity_){
        capacity = capacity_;
        front = size = 0;
        rear = capacity -1;
        a = new  int[capacity];
    }
    boolean is_empty(){
        return (size == 0);
    }
    boolean is_full(){
        return (size == capacity);
    }
    boolean enqueue(int x){
        if(is_full()) {
            System.out.println("Queue Full");
            return false;
        }
        else{
            rear = (rear + 1)%capacity;
            a[rear]=x;
            size++;
            return  true;
        }
    }
    int dequeue(){
        if(is_empty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        else {
            int x = a[front++];
            front = front % capacity;
            size--;
            return x;
        }
    }
    int getFront(){
        if(is_empty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        else {
            return a[front];
        }
    }
    int getRear(){
        if(is_empty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        else {
            return a[rear];
        }
    }
}
public class bst {


    public static void Sort(int[] array,int n){

        ArrayList<queue> buckets = new ArrayList<>(10);
        for(int i = 0; i<10;i++){
            buckets.add(new queue(n));
        }
        for(int i = 0; i<5; i++){
            //inner loop complexity = O(n)
            int extractor = (int)Math.pow(10,i);
            for(int j = 0; j < array.length; j++){
                //extract digit at
                int x = array[j]/extractor;
                //to the bucket no x%10
                buckets.get(x%10).enqueue(array[j]);
            }

            int a = 0; //variable to loop through array

            //popping buckets and adding to array

            for(int q = 0; q<10; q++){
                //empty bucket q
                while(!buckets.get(q).is_empty())
                    array[a++]=buckets.get(q).dequeue();
            }
        }
        //end of outer for loop
        //complexity is O(n), as there will be 8 passes for n values



    }


    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int maxv = Integer.MIN_VALUE;
        for (int i = 0; i <n; i++){
            b[i] = s.nextInt();
            if(b[i]!=-1)a[i] = b[i];
            maxv = Math.max(maxv,a[i]);
        }
        Sort(a,n);
        int cummulative_sum = 0;
        int[] map = new int[maxv+1];


        for (int i = a.length-1; i >=0; i--){
            if(a[i]!=-1){
                cummulative_sum+=a[i];
                int idx = a[i];
                map[idx] = cummulative_sum;
            }
        }
        for (int i = 0; i <n; i++){
            if(b[i]==-1) c[i]=-1;
            else{
                int idx = b[i];
                c[i]=map[idx];
            }
        }

        for (int i = 0; i <n; i++)
            System.out.printf("%d ",c[i]);


    }
}
