//package exam;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//class queue{
//    int size;
//    int front;
//    int rear;
//    int capacity;
//    int a[];
//    queue(int capacity_){
//        capacity = capacity_;
//        front = size = 0;
//        rear = capacity -1;
//        a = new  int[capacity];
//    }
//    boolean is_empty(){
//        return (size == 0);
//    }
//    boolean is_full(){
//        return (size == capacity);
//    }
//    boolean enqueue(int x){
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
//    int dequeue(){
//        if(is_empty()){
//            System.out.println("Queue is empty");
//            return Integer.MIN_VALUE;
//        }
//        else {
//            int x = a[front++];
//            front = front % capacity;
//            size--;
//            return x;
//        }
//    }
//    int getFront(){
//        if(is_empty()){
//            System.out.println("Queue is empty");
//            return Integer.MIN_VALUE;
//        }
//        else {
//            return a[front];
//        }
//    }
//    int getRear(){
//        if(is_empty()){
//            System.out.println("Queue is empty");
//            return Integer.MIN_VALUE;
//        }
//        else {
//            return a[rear];
//        }
//    }
//}
//
//
//public class q1 {
//
//    public static void Sort(int[] array,int n){
//
//        ArrayList<queue> buckets = new ArrayList<>(10);
//        for(int i = 0; i<10;i++){
//            buckets.add(new queue(n));
//        }
//        for(int i = 0; i<10; i++){
//            //inner loop complexity = O(n)
//            int extractor = (int)Math.pow(10,i);
//            for(int j = 0; j < array.length; j++){
//                //extract digit at
//                int x = array[j]/extractor;
//                //to the bucket no x%10
//                buckets.get(x%10).enqueue(array[j]);
//            }
//
//            int a = 0; //variable to loop through array
//
//            //popping buckets and adding to array
//
//            for(int q = 0; q<10; q++){
//                //empty bucket q
//                while(!buckets.get(q).is_empty())
//                    array[a++]=buckets.get(q).dequeue();
//            }
//        }
//        //end of outer for loop
//        //complexity is O(n), as there will be 8 passes for n values
//
//
//
//    }
//
//    public static void main(String[] args){
//        Scanner s = new Scanner(System.in);
//        int N = s.nextInt();
//        int K = s.nextInt();
//        int[] a= new int[N];
//        if(K>=N){
//            System.out.println(0);
//            return;
//        }
//        else {
//            for (int i = 0; i < N; i++) {
//                a[i] = s.nextInt();
//            }
//
//            Sort(a,N);
//            for (int i = 0; i < N; i++) {
//                System.out.println(a[i]);
//            }
//            long sum = 0;
//            for(int i = 0; i<N-K;i++){
//                sum+=a[i];
//            }
//            System.out.println(sum);
//            return;
//        }
//
//    }
//
//
//
//}
