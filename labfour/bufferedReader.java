package labfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import labfour.queue;



public class bufferedReader {
    public static void main(String[] args) throws IOException{
        Reader s = new Reader();
        //Initialize input source as Console Input
        Reader.init(System.in);
        String x = new String();
        x = s.nextline();
        System.out.printf("%s%n",x);
        int T = s.nextint();
        queue q = new queue(10);
        q.dequeue();
        q.getFront();
        q.getRear();
//        q.dequeue();

        for (int t= 0; t < T; t++){
            q.enqueue(s.nextint());
        }
        System.out.println(q.getFront());
        System.out.println(q.getRear());
        System.out.println(q.size);
        System.out.println("Now dequeueing!");
        for (int t= 0; t < T; t++){
            System.out.println(q.dequeue());
            System.out.printf("current size: %d%n",q.size);
        }
    }

}


//Reader Template for Faster I/O
class Reader {

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextint() throws IOException {
        return Integer.parseInt( next() );
    }

    static long nextlong() throws IOException {
        return Long.parseLong( next() );
    }
    static String nextline() throws IOException {
        String str = "";
        try {
            str = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    static double nextdouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
