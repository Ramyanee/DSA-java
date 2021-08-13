package bsearch;
import java.util.*;

public class bsearch{

    public static int iterbsearch(int[] sortedArr, int key){

        int left = 0;
        int right = sortedArr.length;
        int middleEle = (left + right)/2;
        boolean found = false;
        int key_index = -1; // will return -1 if not found

        while (left<right && found==false){

            middleEle = (left + right)/2;
            int x=sortedArr[middleEle];

            if(x==key){
                found = true;
                key_index = middleEle;
            }
            else{
                if(key>x){
                    //look right
                    left = middleEle+1;

                }
                else{
                    //look left
                    right = middleEle;
                }
            }


        }

        return key_index;



    }


    public static void main(String[] args){

        // *****input notes*****

        // considering the input order:

        // n
        // k
        // arr

        // where n is the size of the array, k is the key we are searching for, and arr is a sorted array of size n.
        // sorted array arr to be input one element at a time.


        Scanner s = new Scanner(System.in);

        //n
        int arsize = s.nextInt();

        //k
        int key = s.nextInt();

        int arr[];
        arr = new int[arsize];
        
        //arr
        for(int i =0;i<arsize;i++){
            arr[i]=s.nextInt();
        }



        
        s.close();

        int idx = iterbsearch(arr, key);

      
        System.out.printf("%d",idx);
    
    }
}