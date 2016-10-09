package Implementation;
/*
    Coder : lordzuko
    Time  : 2:57 AM
    Date  : 10/10/2016
    
*/

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
        MatrixLayerRotation solver = new MatrixLayerRotation();
        //int n = in.nextInt();
        solver.solve(1, in, out);
        out.close();
        System.exit(0);
    }
}

class MatrixLayerRotation {

    private int numberRing;
    private int numberRotations;
    private int m,n,r;
    private int[][] mat;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        m= in.nextInt();
        r = in.nextInt();
        mat = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j] = in.nextInt();
            }
        }

        numberRing = Math.min(n,m)/2;

        for(int i=0;i<numberRing;i++){

            // number of ratations per ring  = perimeter of the ring
            // in each row or col number of swaps required = len(row|col) - 1
            // mod is for you should have guessed by now !!
            // what's the point of doing same thing again ryt ;)
            // ya ya I know its 3:34 AM and I have no one to talk :D
            // all that is left is to copy the code I have written on notebook to intelliJ
            // let the typing begin !!!!!!
            numberRotations = r%(2*(n+m-4*(i))-4);
            for(int rot = 0;rot < numberRotations;rot++){
                // top row
                for(int j=i;j<m-i-1;j++){
                    swap(i,j,i,j+1);
                }
                // right col
                for(int j=i;j<n-i-1;j++){
                    swap(j,m-i-1,j+1,m-i-1);
                }
                // bottom row
                for(int j=m-i-1;j>i;j--){
                    swap(n-i-1,j,n-i-1,j-1);
                }
                // left col
                for(int j=n-i-1;j>i+1;j--){
                    swap(j,i,j-1,i);
                }
            }
        }

        printMatrix();
    }

    private void swap(int i,int j , int x,int y){
        mat[i][j] = mat[i][j]^mat[x][y];
        mat[x][y] = mat[i][j]^mat[x][y];
        mat[i][j] = mat[i][j]^mat[x][y];
    }

    private void printMatrix(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
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