package Graph;
/*
    Coder : lordzuko
    Time  : 12:16 PM
    Date  : 10/9/2016
    
*/

import javax.security.sasl.SaslServer;
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
        CountLuck solver = new CountLuck();
        int n = in.nextInt();
        solver.solve(n, in, out);
        out.close();
        System.exit(0);
    }
}

class CountLuck {
    int n,m,k;
    char[][] mat;
    static int[] dx ,dy;
    int cnt;
    public CountLuck(){
        dx = new int[]{1,-1,0,0};
        dy = new int[]{0,0,-1,1};
        cnt=0;
    }

    private boolean isSafe(int x,int y){
        return (x>=0) && (y>=0) && (x < n) && (y < m);
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        while(testNumber -- >0) {
            cnt=0;
            n = in.nextInt();
            m = in.nextInt();
            int mx=0,my=0;
            mat = new char[n][m];
            for (int i = 0; i < n; i++) {
                mat[i] = in.next().toCharArray();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 'M') {
                        mx = i;
                        my = j;
                        break;
                    }
                }
            }

            dfs(mx, my);
            k = in.nextInt();
            if (cnt == k)
                System.out.println("Impressed");
            else
                System.out.println("Oops!");
            //System.out.println(cnt);
            //System.out.println("---------------------");
        }
    }

    public void dfs(int mx, int my){
        dfs(mx,my,-1,-1);
    }

    private boolean dfs(int x,int y,int px,int py){

        if(mat[x][y] == '*') {
            //System.out.println("hit");
            return true;
        }
        boolean pathAvail = false;
        int noPathAvail = 0;

        for (int i = 0; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!isSafe(nx,ny)) {
                continue;
            }
            // nx should not go back to its parent
            if(nx == px && ny == py) {
                continue;
            }
            if(mat[nx][ny] == 'X') {
                continue;
            }
            if(dfs(nx,ny,x,y)){
                pathAvail=true;
            }
            noPathAvail++;
        }
        if(pathAvail && noPathAvail > 1) {
            ++cnt;
        }

        return pathAvail;
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