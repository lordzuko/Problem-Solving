package BlueOptima.BinaryPalindrome;

/*
    Coder : lordzuko
    Time  : 11:03 AM
    Date  : 9/24/2016

*/

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
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
        BinaryPalindrome solver = new BinaryPalindrome();
        int n = in.nextInt();
        solver.solve(n, in, out);
        out.close();
        System.exit(0);
    }
}

class BinaryPalindrome {

    private int n,j;
    HashMap<Integer,Integer> m;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        m = new HashMap<>();
        j=1;
        for(int i=1;i<=1000000000;i++){
            if(isPal(i)){
                m.put(j,i);
                j++;
            }
        }

        while (testNumber-- >0 ){
            n = in.nextInt();
            System.out.println(m.get(n));
        }
    }


    public static boolean isPal(int orig)
    {
        int copy = orig;
        int reversed = 0;

        while(copy!=0)
        {
            reversed <<= 1;
            reversed |= (copy & 1);
            copy >>>= 1;
        }
        return (reversed == orig);
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