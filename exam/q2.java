//package exam;
//
//import java.util.Scanner;
//
//
//class queue{
//    int size;
//    int front;
//    int rear;
//    int capacity;
//    long a[];
//    queue(int capacity_){
//        capacity = capacity_;
//        front = size = 0;
//        rear = capacity -1;
//        a = new  long[capacity];
//    }
//    boolean is_empty(){
//        return (size == 0);
//    }
//    boolean is_full(){
//        return (size == capacity);
//    }
//    boolean enqueue(long x){
//        if(is_full()) {
//            System.out.println("Queue Full");
//            return false;
//        }
//        else{
//            rear = (rear + 1)%capacity;
//            a[rear]=x;
//            size++;
//            return  true;
//        }
//    }
//    long dequeue(){
//        if(is_empty()){
//            System.out.println("EMPTY");
//            return Integer.MIN_VALUE;
//        }
//        else {
//            long x = a[front++];
//            front = front % capacity;
//            size--;
//            return x;
//        }
//    }
//    long getFront(){
//        if(is_empty()){
//            System.out.println("EMPTY");
//            return Integer.MIN_VALUE;
//        }
//        else {
//            return a[front];
//        }
//    }
//    long getRear(){
//        if(is_empty()){
//            System.out.println("EMPTY");
//            return Integer.MIN_VALUE;
//        }
//        else {
//            return a[rear];
//        }
//    }
//    void inc(int x,long d){
//        int n = rear;
//        for(int i = 0; i < x; i++){
//            a[n] = a[n]+d;
//            n--;
//        }
//    }
//}
//
//
//public class q2 {
//
//
//    public static void main(String[] args){
//
//        Scanner s = new Scanner(System.in);
//
////        System.out.println(x.equals("enqueue 4"));
//
//        int T = s.nextInt();
//        queue Q = new queue(1000);
//        for(int t = 0; t < T; t++){
//            String x = s.next();
//            if(x.equals("enqueue")){
//                long a = s.nextLong();
//                Q.enqueue(a);
//                if(Q.is_empty())System.out.println("EMPTY");
//                else System.out.println(Q.getFront());
//
//            }
//            else if(x.equals("dequeue")){
//                long ret = Q.dequeue();
//                if(ret == Integer.MIN_VALUE) continue;
//                if(Q.is_empty())System.out.println("EMPTY");
//                else System.out.println(Q.getFront());
//            }
//            else if(x.equals("inc")){
//                int a = s.nextInt();
//                long d = s.nextLong();
//                Q.inc(a,d);
//                if(Q.is_empty())System.out.println("EMPTY");
//                else System.out.println(Q.getFront());
//
//            }
//        }
//
//
//
//
//
//    }
//
//}
