package freeryloth;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class freeRyloth {
    public static void makeTree(String input, String nodes, ArrayList<ArrayList<Character>> tree ){

        for (int i = 0; i < input.length(); i++){
            int idx;
            char x = input.charAt(i);
            char rchild,lchild;
            //if ith node in the input array is not 'N'
            if(Character.isDigit(x)){
                //get its numeric value
                int xi = Character.getNumericValue(x);
               idx = nodes.indexOf(x);
               //if no child, break out of the loop
               if(idx*2+1>=input.length()) break;
               lchild = input.charAt(idx*2+1);
               rchild = input.charAt(idx*2+2);
               //if its left child is also a int
                //add this link to the lists of both
                //the current node and its child
               if(Character.isDigit((lchild))){
                   //list for the current node
                   tree.get(xi).add(lchild);
                   //list for the left child node
                   tree.get(Character.getNumericValue((lchild))).add(x);
               }
                //if its right child is also an int
                // add this link to the lists of both
                //the current node and its child
               if(Character.isDigit((rchild))){
                   //list for the current node
                   tree.get(xi).add(rchild);
                   //list for the left child node
                   tree.get(Character.getNumericValue((rchild))).add(x);

               }

            }
        }
    }
    public static int spreadInfo(ArrayList<ArrayList<Character>> tree, char houseno, String nodes, int m){
        int[] levels = new int[m+1];
        for(int i = 0; i<m+1; i++){
            levels[i]=-1;
        }
        int k = Character.getNumericValue(houseno);
        int hours = 0;
        levels[k]=0;
        Deque<Character> X = new ArrayDeque<>();
        X.addLast(houseno);
        //outer loop runs for all the unvisited nodes, therefore max n times
        while(true){
            //since it's a binary tree, this inner loop will run maximum 3 times.
            for(int i = 0; i <tree.get(k).size();i++){
                int x =  Character.getNumericValue(tree.get(k).get(i));
                if(levels[x]==-1) { //System.out.printf("k here is %d %n",k);
                    levels[x] = levels[k]+1;
                X.addLast(tree.get(k).get(i));
                hours = Math.max(hours,levels[x]);}
            }
            if(!X.isEmpty()) {
                k = Character.getNumericValue(X.removeFirst());
            }
            else break;
        }
        //runs at maximum 3*n. Therefore it is O(n).

    return hours;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        char firstHouse = s.next().charAt(0);
        s.close();
        //preprocess theinpt to construct the tree
        input = input.replaceAll(" ","");
        String nodes = input.replaceAll("N","");
        int maxnode = 0;
        for(int i = 0; i<nodes.length();i++)
            maxnode = Math.max(maxnode,Character.getNumericValue(nodes.charAt(i)));
        //initialising the tree
        ArrayList<ArrayList<Character>> tree = new ArrayList<>(maxnode+1);
        for(int i = 0; i< maxnode+1; i++) tree.add(new ArrayList<>());
        //constructing the tree
        makeTree(input,nodes,tree);
        //traversing
        System.out.println(spreadInfo(tree,firstHouse,nodes,maxnode));


    }
}
