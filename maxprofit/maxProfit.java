package maxprofit;
import java.util.*;


public class maxProfit {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for(int t =0; t< T; t++){

            Deque<Integer> KQ= new ArrayDeque<Integer>();
            // I am using variables T,N,K as per the question

            // getting individual test cases
            int N = s.nextInt();
            int K = s.nextInt();
            int[] houses = new int[N];
            for(int j =0; j<N; j++){
                houses[j]= s.nextInt();
            }

            


            //entering the first k elements in sorted order
            //the first(head) side of the deque will contain the index of the largest element
            //smallest elements are towards the last(tail)

            for(int k = 0; k<K; k++){
                int currHouse = houses[k];
                while(KQ.isEmpty()==false){
                int idx = KQ.peekLast();
                if(currHouse<houses[idx]) break;
                KQ.removeLast();
                }
                KQ.add(k);
            }



            System.out.printf("%d ",houses[KQ.peek()]);

            for (int n = K; n< N; n++){

                int h_idx, h, currHouse;
                currHouse = houses[n];
                
                //System.out.printf("p1");

                int groupLimit = n-K;

                while(KQ.isEmpty()==false){
                    //System.out.printf("p2");
                    if(KQ.peekFirst()>groupLimit)break;
                    KQ.pop();
                }

                while(KQ.isEmpty()==false){
                    int idx = KQ.peekLast();
                    if(currHouse<houses[idx]) break;
                    //System.out.printf("p3");
                    KQ.removeLast();

                }
                KQ.add(n);
                h_idx = KQ.peek();
                h = houses[h_idx];
                

                System.out.printf("%d ",h);
                
            }
            

            


        }
        s.close();











    }
}
