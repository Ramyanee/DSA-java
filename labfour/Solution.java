package labfour;
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        for(int i =0; i < t; i++){
            int n = s.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++){
                arr[j]=s.nextInt();
            }
            int cost = 0;
            int prevcost = 0;
            Arrays.sort(arr);
//            for(int j = 0; j<n; j++){
//                System.out.println(arr[j]);
//            }
            prevcost= arr[0]+arr[1];
            cost = prevcost;
            for(int j = 2; j<n; j++){
                //System.out.printf("cost %d arr[j] %d %n",cost,arr[j]);
                prevcost+=arr[j];
                cost+=prevcost;
            }

            System.out.printf("%d%n",cost);



            }

        }

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
