package bigcube;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BigCube {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for(int x = 0; x < t; x++){
            int sum = 0;
            int n = s.nextInt();
            PriorityQueue<Integer> cubes = new PriorityQueue<>();
            for(int i = 0; i < n; i++){
                cubes.add(s.nextInt());
            }
           while(cubes.size()>=2){
               int a = cubes.poll();
               int b = cubes.poll();
               int c = a+b;
               sum+=c;
               cubes.add(c);
           }
           System.out.println(sum);
        }
        s.close();
    }
}
