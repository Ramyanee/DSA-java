package maximumprofit;
import java.util.*;

public class maximumprofit {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for(int i =0; i< T; i++){

            ArrayList<Integer> Q = new ArrayList<>();
            
            int N = s.nextInt();
            int K = s.nextInt();

            for(int j =0; j<N; j++){
                Q.add(s.nextInt());
            }

            int max = Q.get(0);

            for(int j =0; j<K; j++){
                int x = Q.get(j);
                if(x>max)max=x;
            }
            System.out.printf("%d ",max);
            for(int j=K;j<N;j++){
                int y = Q.get(j);
                if(max<y){
                    max = y;   
                }
                System.out.printf("%d ",max);
            }
            System.out.printf("%n");



        }
        s.close();


    }
    
}
