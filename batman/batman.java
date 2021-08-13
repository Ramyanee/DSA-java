package batman;

import java.util.*;
import java.lang.Math;


public class batman {

    public static void findBatman(int[][] matrix,int P){

        
        boolean[] batman=new boolean[P];
        
        int remainingCandidates = P;
        int t = 0;

        for(int i =0; i<P; i++) batman[i]=true;

        

        //elimination code start

        for(int i = 0; i < P; i++){

            for(int j =0; j<P; j++){
                t++;
                if(i==j)continue;
                else{
                    //if i does not know person j, j cannot be batman
                    if (matrix[i][j]==0 && batman[j]==true){
                        batman[j]=false;
                        remainingCandidates--;
                    }

                    //if matrix[i][j]!=0, it means it is 1, implies, 
                    //i knows someone, and i cannot be batman.
                    //on knowing for the first time that i is not batman, 
                    //eliminate i from candidates and 
                    //decrease the number of candidates by 1
                    else if(matrix[i][j]==1 && batman[i]==true){
                        remainingCandidates--;
                        batman[i]=false;
                    }
                }
                if(remainingCandidates<=1) break;                   
            }
            if(remainingCandidates<=1) break;
        }

            //elimination code over

        int t2 = 0;
        // verification code
        for (int i = 0; i < P; i++){
            t2++;
            if(batman[i]){
                int colsum = 0;
                int e = 0;
                for (int x = 0; x < P; x++){
                    t2++;
                    colsum+=matrix[i][x];
                    e+=matrix[x][i];
                }
                if(colsum==0 && e==(P-1)){
                    System.out.printf("\n%d\n",i);
                    return;
                }
            }
        }

    System.out.printf("\n-1");

    }



    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int P = s.nextInt();
        int[][] matrix= new int[P][P];
        for(int i =0; i<P; i++)
        for(int j =0; j<P; j++)
        matrix[i][j] = s.nextInt();

        s.close();

        findBatman(matrix, P);

    
            
    }
}
    
