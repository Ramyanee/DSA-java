package placementsession;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class placementSession {

    public static void _placementSession(int[] array){
        int n = array.length;
        int[] seq = new int[3];
        int globalProduct = (int) Integer.MIN_VALUE;
        boolean possible = false;
        for(int i = 0; i < n; i++){
            Deque<Integer> o = new ArrayDeque<>(3);
            o.addLast(array[i]);
            int lastmax = array[i];
            for(int j = i+1; j <n; j++) {
                if (array[j] > lastmax) {
                    lastmax = array[j];
                    if (o.size() == 3) {
                        o.removeFirst();
                    }
                    o.addLast(lastmax);
                }
            }
            if(o.size()==3) possible=true;
            Iterator it = o.iterator();
            int product = 1;
            while (it.hasNext()){
                product = product*(int)it.next();
            }
            if(product>=globalProduct && o.size()==3){
                globalProduct = product;
                seq[0]=o.removeFirst();
                seq[1]=o.removeFirst();
                seq[2]=o.removeFirst();

            }
        }
        if(!possible) System.out.println(-1);
        else{
            System.out.printf("%d ",seq[0]);
            System.out.printf("%d ",seq[1]);
            System.out.printf("%d ",seq[2]);
        }

    }
    public static void main(String[] arg){

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();


        for(int i = 0; i < t; i++){
            int n = s.nextInt();
            int[] packages = new int[n];
            int[] prods = new int[n];

            for(int j = 0; j < n; j++){
                packages[j] = s.nextInt();
                prods[j]= packages[j]*j;
            }
            _placementSession(packages);
            System.out.printf("%n");
        }

    }


}

