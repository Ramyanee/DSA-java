package scoreboard;

import java.io.*;
import java.util.*;

public class scoreboard {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        for(int i =0; i < t; i++){
            int n = s.nextInt();
            ArrayList<Integer> u = new ArrayList<>(n);
            ArrayList<Integer> st = new ArrayList<Integer>(n);
            for(int j =0;j<n;j++){
                u.add(s.nextInt());
                st.add(u.get(j));
            }
            Collections.sort(st, Collections.reverseOrder());

            for (int j = 0; j<n; j++){
                int x = st.get(j);

                int idx = u.lastIndexOf(x);
                u.set(idx,-1);
                System.out.printf("%d ",++idx);

            }
            System.out.printf("%n");
        }

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}