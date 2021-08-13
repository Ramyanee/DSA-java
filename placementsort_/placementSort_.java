package placementsort_;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

class student{
    String rn;
    String name;
    int p;
}
public class placementSort_ {

    //search
    //since this search function will get a sorted array
    //as the array is being sorted as part 1 of this question
    //we can implement binary search to search in this array

    public static int _search(int key, student[] array, int l, int r){
        int count = 0;
        int c = (l+r)/2;
        if (array[c].p==key) {
            //if the middle element is the key,
            //all other elements equal to it must be present in it's vicinity only
            // look left, look right, count
            count++;
            for(int x =c-1; x>-1; --x) {

                if (array[x].p == key) {
                    count++;
                }
                else break;
            }
            for(int x =c+1; x<array.length; x++) {
                if (array[x].p == key) {
                    count++;
                }
                else break;
            }
            return count;

        }
        //if one or less element remains and then also it's not a match,
        //the key is not present
        else  if(r-l<=1) return count;
        else{
            if(array[c].p>key) {
                count = _search(key, array, l, c);
            }
            else if(array[c].p<key) {
                count = _search(key, array, c, r);
            }
            return count;
        }

    }


    public static void placementSort(student[] array){

        //auxiliary space complexity = O(n)
        //at each pass n values needs to be stored
        ArrayList<ArrayDeque<student>> buckets = new ArrayList<>(10);
        for(int i = 0; i<10;i++){
            buckets.add(new ArrayDeque<student>());
        }
        //total number of passes <=8 as max value is 10^7
        for(int i = 0; i<8; i++){
            //inner loop complexity = O(n)
            int extractor = (int)Math.pow(10,i);
            for(int j = 0; j < array.length; j++){
                //extract digit at
                int x = array[j].p/extractor;
                //to the bucket no x%10
                buckets.get(x%10).addLast(array[j]);
            }

            int a = 0; //variable to loop through array

            //popping buckets and adding to array

            for(int q = 0; q<10; q++){
                //empty bucket q
                while(!buckets.get(q).isEmpty())
                    array[a++]=buckets.get(q).removeFirst();
            }
        }
        //end of outer for loop
        //complexity is O(n), as there will be 8 passes for n values



    }

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        student[] array = new student[n];

//      getting input and constructing the student array
        for(int i=0;i<n;i++){
            student x = new student();
            x.rn = s.next();
            x.name = s.next();
            x.p = s.nextInt();
            array[i]=x;
        }


//      sorting the student array
        placementSort(array);


//      getting number of test cases to search
        int k = s.nextInt();
        int[] res = new int[k];
        //getting search test cases and passing them to the searching algorithm
        //result is stored in the res[] array
        for(int i=0;i<k;i++){
            int key = s.nextInt();
            res[i]=_search(key,array,0,n);
        }
//        printing the outputs
        for(int i =0;i<n;i++)
            System.out.printf("%s %s %d%n",array[i].rn,array[i].name,array[i].p);
        for(int i=0;i<k;i++){
            System.out.println(res[i]);
        }



    }
}



