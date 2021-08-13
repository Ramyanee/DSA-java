package placementsort;

import java.util.Scanner;

class student{
    String rn;
    String name;
    int p;
}
public class placementSort {

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


    //implementing a mergesort for the sorting part
    //selected to implement merge sort because it is stable
    //which is a requirement in the question
    public static void merge(student[] array,int l, int r, int c){

        if(array[c-1].p>array[c].p){

            int size = r-l;
            int i=l,j=c,ti=0;
            student[] aux = new student[size];
            for(int s = 0; s< size; s++) aux[s] = new student();
            while(i<c && j<r){
                if(array[i].p<=array[j].p)aux[ti++]=array[i++];
                else aux[ti++]=array[j++];
            }
            System.arraycopy(array,i,array,l+ti,c-i);
            System.arraycopy(aux,0,array,l,ti);

        }
        else {
            return;
        }

    }
    //implementing mergesort as the stablesort algorithm
    public static void stablesort(student[] array, int l, int r){
        if(r-l<=1)return;
        int centre = (l+r)/2;
        stablesort(array,l,centre);
        stablesort(array,centre,r);
        merge(array,l,r,centre);

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
        stablesort(array,0,n);


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



