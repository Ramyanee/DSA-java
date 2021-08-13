package deadlinesort;
import java.lang.Math;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class deadlineSort {
    //This function implements the radix sort algorithm
    public static void dsort(int[] array, int k){

        //auxiliary space complexity = O(k)
        ArrayList<ArrayDeque<Integer>> buckets = new ArrayList<>(k);
        for(int i = 0; i<k;i++){
            buckets.add(new ArrayDeque<Integer>());
        }
        //total number of passes = 2
        for(int i = 0; i<2; i++){
            //inner loop complexity = O(k)
            int extractor = (int)Math.pow(k,i);
            for(int j = 0; j < k; j++){
                //extract digit at
                int x = array[j]/extractor;
                //to the bucket no x%k
                buckets.get(x%k).addLast(array[j]);
            }

            int a = 0; //variable to loop through array

            //popping buckets and adding to array
            //O(k)
            for(int q = 0; q<k; q++){
                //empty bucket q
                while(!buckets.get(q).isEmpty())
                    array[a++]=buckets.get(q).removeFirst();
            }
        }
        //end of outer for loop
        //complexity is O(k),
        //because base k representation gives only two digits for
        //0 to k^2-1
        //therefore there are two passes through k numbers


    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        int maxdigit = 0;
        int[] deadlines = new int[k];

        for(int i =0; i<k;i++){
            deadlines[i]=s.nextInt();
        }

        dsort(deadlines,k);
        for(int i =0; i<k;i++){
            System.out.printf("%d ",deadlines[i]);
        }
    }
}
