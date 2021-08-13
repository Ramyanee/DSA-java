// import java.util.*;

// class houseData{
//     int idx;
//     int value;

//     public houseData(int a, int b){
//         idx = a;
//         value = b;
//     }
// }


// public class mp {
//     public static void main(String[] args){

//         Scanner s = new Scanner(System.in);

//         int T = s.nextInt();

//         for(int t =0; t< T; t++){

//             Deque<houseData> KQ= new ArrayDeque<houseData>();
//             // I am using variables T,N,K as per the question
//             // getting individual test cases
//             int N = s.nextInt();
//             int K = s.nextInt();
//             int[] houses = new int[N];
//             for(int j =0; j<N; j++){
//                 houses[j]= s.nextInt();
//             }

//             //entering the first k elements in sorted order
//             //the first(head) side of the deque will contain the index of the largest element
//             //smallest elements are towards the last(tail)

//             for(int k = 0; k<K; k++){

//                 int currHouse = houses[k];
//                 houseData d = new houseData(k,currHouse);

//                 if(KQ.isEmpty()==true){
//                     KQ.add(d);
//                 }

//                 else{

//                     while(currHouse>=KQ.peekLast().value){
//                         KQ.removeLast();
//                         if(KQ.isEmpty()==true) break;
//                         }
//                     KQ.add(d);

//                 }
//             }
//             System.out.printf("%d ",KQ.peek().value);

//             // iterating through the rest of the array
//             for (int n = K; n< N; n++){

//                 int currHouse;
//                 currHouse = houses[n];
                
//                 //System.out.printf("p1");

//                 int groupLimit = n-K;

//                 while(KQ.isEmpty()==false){
//                     //System.out.printf("p2");
//                     if(KQ.peekFirst().idx>groupLimit)break;
//                     KQ.pop();
//                 }

//                 while(KQ.isEmpty()==false){
//                     if(currHouse<KQ.peekLast().value) break;
//                     //System.out.printf("p3");
//                     KQ.removeLast();

//                 }
//                 houseData d = new houseData(n,currHouse);
//                 KQ.add(d);
//                 System.out.printf("%d ",KQ.peek().value);
                
//             }

//             System.out.printf("%n");
//         }
//         s.close();

//     }
// }
