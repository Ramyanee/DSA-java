package labfour;

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

public class Solution3 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        queue q = new queue(10);
        q.dequeue();
        q.getFront();
        q.getRear();
//        q.dequeue();

        for (int t= 0; t < T; t++){
            q.enqueue(s.nextInt());
        }
        System.out.println(q.getFront());
        System.out.println(q.getRear());
        System.out.println(q.size);
        System.out.println("Now dequeueing!");
        for (int t= 0; t < T; t++){
            System.out.println(q.dequeue());
            System.out.printf("current size: %d%n",q.size);
        }
    }


}
