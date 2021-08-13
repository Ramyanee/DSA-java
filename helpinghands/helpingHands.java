package helpinghands;
import java.util.*;
class p{
    int x;
    int y;}


class xsort implements Comparator<p>{
    public int compare(p a, p b){
        if(a.x==b.x) return  0;
        else if(a.x>b.x) return 1;
        else return -1;
    }
}

class ysort implements Comparator<p>{
    public int compare(p a, p b){
        if(a.y==b.y) return  0;
        else if(a.y<b.y) return 1;
        else return -1;
    }
}

//0-4,5-5


public class helpingHands{
    public static int helpinHands(ArrayList<p> pairs, int k){

        int minimumHelpers = 1;
        int cub,ii,mub;

        if (pairs.get(0).x != 0) return -1;
        else if(pairs.get(0).y==k) return minimumHelpers;
        else {
            cub = pairs.get(0).y;
        }
//        cub is the current upper bound
        for(int i = 0; i< pairs.size();){
            ii = i+1;
            mub=cub;
            boolean whileexecuted=false;
//            System.out.printf("%n***current cub %d ii=%d%n",cub,ii);
            // greedily selecting the next best helper
            //who has the highest range
            //but also does not leave any uncovered people in the middle.
            //if our present helper is providing till kth person,
            //the next helper must start on or before k+1'th person.
            //this step ensures that we cover maximum number of people
            //using least number of helpers.
            while( ii < pairs.size() && pairs.get(ii).x<=(cub+1)){
                whileexecuted=true;
                if(pairs.get(ii).y>mub)mub = pairs.get(ii).y;
                ii++;
            }
            //once we find the next best helper, we increment the number of helpers
            ++minimumHelpers;
             if (mub == k) return minimumHelpers;
             else{
                 cub = mub;
                 if(whileexecuted)i = --ii;
                 else i++;
             }
//             System.out.printf("%ncurrent cub %d%n",cub);
        }
        //if at the end of the procedure the upper bound of our coverage by helpers
        //matches the maximum people (0 to n-1) then we can say that
        //it is possible to feed all the people with our helper's help
        //if not, then it is not possible
        if(cub == k) return minimumHelpers;
        else return -1;

    }

    public  static void main(String[] args){
        ArrayList<p> pairs = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i =0; i<t;i++){
            int x = s.nextInt();
            if(x!=-1){
                p helper = new p();
//                while entering, we are clipping the
//                range of our helpers to minimum of 0
//                and maximum of n-1
                helper.x = Math.max(0,i-x);
                helper.y = Math.min(x+i,t-1);
                pairs.add(helper);
            }
        }
        s.close();
//        for(int i=0; i<pairs.size();i++)
//            System.out.printf("%n%d %d %n",pairs.get(i).x,pairs.get(i).y);
        Collections.sort(pairs,new xsort().thenComparing(new ysort()));
//        for(int i=0; i<pairs.size();i++)
//            System.out.printf("%n%d %d %n",pairs.get(i).x,pairs.get(i).y);
        System.out.println(helpinHands(pairs,t-1));
    }


}
