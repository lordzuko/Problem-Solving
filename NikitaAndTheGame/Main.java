package DP;/*
    Coder : lordzuko
    Time  : 7:09 PM
    Date  : 10/11/2016
    
*/

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        NikitaAndTheGame solver = new NikitaAndTheGame();
        int n = in.nextInt();
        solver.solve(n, in, out);
        out.close();
        System.exit(0);
    }
}

class NikitaAndTheGame {
    long[] A;
    int n;
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        while (testNumber -- > 0){
            n = in.nextInt();
            A = new long[n];
            Arrays.fill(A,0);
            for (int i = 0; i <n ; i++) {
                A[i] = in.nextLong();
            }

            System.out.println(findWays(0,n));
        }
    }


    private long findWays(int l,int r){
        long sum=0,ways = 0;
        int pos = 0;
        boolean allzeroes = true;
        for(int i=l;i<r;i++){
            sum+=A[i];
            if(A[i]!=0){
                allzeroes = false;
            }
        }

        if(allzeroes == true){
            return r-l-1;
        }
        // cannot be divided into two halves evenly
        if(sum%2 !=0) {
            return ways;
        }else{
            long sub_sum =0;
            for(int i=l;i<r;i++){
                if(sub_sum != sum/2 && sub_sum < sum/2 ) {
                    sub_sum += A[i];
                }else{
                    pos = i;
                    break;
                }
            }
            if(sub_sum == sum/2){
                ways = 1 + Math.max(findWays(l,pos),findWays(pos,r));
            }else {
                return ways;
            }
        }
        return ways;
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
    public long nextLong() {return Long.parseLong(next());  }

}