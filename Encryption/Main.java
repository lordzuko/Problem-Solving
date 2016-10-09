package Implementation;/*
    Coder : lordzuko
    Time  : 8:47 PM
    Date  : 10/9/2016
    
*/

import sun.nio.cs.ext.MacHebrew;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.lang.*;


class Main {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        // Create an object of your solution class here
        Encryption solver = new Encryption();
        //int n = in.nextInt();
        solver.solve(1, in, out);
        out.close();
        System.exit(0);
    }
}

class Encryption {
    private String s;
    private int len,r,c,cnt;
    char[][] arr;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        s = in.next();
        len = s.length();
        r = (int)Math.floor(Math.sqrt(len));
        c = (int)Math.ceil(Math.sqrt(len));
        if(r*c < len) {
            r += 1;
        }

        arr = new char[r][c];
        cnt=0;
        for (int j = 0; j < c; j++) {
            for(int i = 0; i < r;i++){
                if(i*c+j >= len) break;
                System.out.print(s.charAt(i*c+j));
            }
            System.out.print(" ");
        }



    }


}


class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

}