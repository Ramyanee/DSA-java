package maxp;
import java.util.*;


class houseData{
    int idx;
    int value;

    public houseData(int a, int b){
        idx = a;
        value = b;
    }
}

//hey this a change
public class maxp{
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        ArrayList<ArrayList<Integer>> results = new ArrayList<>(T);
        for(int i=0; i < T; i++) {
            results.add(new ArrayList());
        }

        for(int t =0; t< T; t++){

            Deque<houseData> valueOrder= new ArrayDeque<houseData>();
            // I am using variables T,N,K as per the question
            // getting individual test cases
            int N = s.nextInt();
            int K = s.nextInt();
            int[] houses = new int[N];
            for(int j =0; j<N; j++){
                houses[j]= s.nextInt();
            }

            //entering the first k elements in sorted order
            //the first(head) side of the deque will 
            //contain the index of the largest element
            //smallest elements are towards the last(tail)

            for(int k = 0; k<K; k++){

                int currHouse = houses[k];
                houseData d = new houseData(k,currHouse);

                if(valueOrder.isEmpty()==true){
                    valueOrder.add(d);
                }

                else{

                    while(currHouse>=valueOrder.peekLast().value){
                        valueOrder.removeLast();
                        if(valueOrder.isEmpty()==true) break;
                        }
                    valueOrder.add(d);

                }
            }

            houseData currentMax = valueOrder.peek();
            //System.out.printf("%d ",currentMax.value);
            results.get(t).add(currentMax.value);

            // iterating through the rest of the array
            for (int n = K; n< N; n++){

                int groupLimit = n - K+1;
                int currVal = houses[n];

                //if existing max in in range
                if(currentMax.idx>=groupLimit){
                    //if existing max is greater than the new value
                    //just push the current value to valueOrder 
                    //by removing all prior smaller values
                    //existing value must be printed
                    if(currentMax.value>currVal){

                        while(valueOrder.isEmpty()==false && valueOrder.peekLast().value<currVal)
                        valueOrder.removeLast();

                        houseData d = new houseData(n, currVal);
                        valueOrder.add(d);
                        



                    }
                    // if existing max is smaller than the new value, 
                    //currentmax must be updated
                    else{
                        houseData d = new houseData(n, currVal);
                        currentMax = d;
                        //means all the values in the 
                        //valueOrder are smaller than the new value
                        while(valueOrder.isEmpty()==false) valueOrder.pop();
                        valueOrder.add(d);

                    }
                }
                //if currentMax has gone out of  the limit
                else{
                    //purging all expired values 
                    //from the valueOrder's front side
                    while(valueOrder.peekFirst().idx<groupLimit && valueOrder.isEmpty()==false) 
                    valueOrder.removeFirst();

                    while(valueOrder.isEmpty()==false && valueOrder.peekLast().value<currVal)
                        valueOrder.removeLast();

                    houseData d = new houseData(n, currVal);
                    valueOrder.add(d);
                    currentMax = valueOrder.peekFirst();


                }
                results.get(t).add(currentMax.value);
                //System.out.printf("%d ",currentMax.value);
                
            }

            System.out.printf("%n");
        }
        s.close();

        for(int t =0; t< T; t++){
            for(int i=0;i<results.get(t).size();i++){
                System.out.printf("%d ",results.get(t).get(i));
            }
            System.out.printf("%n");
        }

    }
}
