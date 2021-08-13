package iiitdcontest;

import java.util.*;

public class IIITDContest {
    public static void color(ArrayList<Integer>[] friends,int n){
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i]=-1;
        }
        Deque<Integer> s = new ArrayDeque<>(n);
        s.addLast(1);
        colors[1] = 1;
        while(!s.isEmpty()){
            int x = s.removeFirst();
            for(int i = 0; i < friends[x].size();i++){
                int y = friends[x].get(i);
                if(colors[y]==-1){
                    s.addLast(y);
                    colors[y] = Math.abs(colors[x]-1);
                }
                else if(colors[x] == colors[y]){
                    System.out.printf("\nno");
                    return;
                }

            }
        }

        System.out.printf("\nyes");

    }


    public static  void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int x = 0; x < t; x++){
            int n = s.nextInt();
            int m = s.nextInt();
            ArrayList<Integer>[] friends = new ArrayList[n+1];
            for (int i = 0; i <= n; i++) {
                friends[i] = new ArrayList<>();
            }
            for(int i = 0; i < m; i++){
                int a,b;
                a = s.nextInt();
                b = s.nextInt();
                friends[a].add(b);
                friends[b].add(a);
            }
            color(friends,n+1);
//            for(int i = 0; i <= n; i++){
//                System.out.printf("%d   ",i);
//                for(int j = 0; j < friends[i].size();j++)
//                    System.out.printf("%d ",friends[i].get(j));
//                System.out.println();
//            }
        }
    }

}