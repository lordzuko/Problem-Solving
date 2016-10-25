package Datami;

/*
    Coder : lordzuko
    Time  : 11:15 AM
    Date  : 9/16/2016
    
*/

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.InputStream;
import java.lang.*;


class Main {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        // Create an object of your solution class here
        Witch solver = new Witch();
        //int n = in.nextInt();
        solver.solve(1, in, out);
        out.close();
        System.exit(0);
    }
}

class TreeNode{
    int num;
    int color;

    public  TreeNode(int n,int c){
        this.num = n;
        this.color = c;
    }
}

/**
 *
 * Test Case:
 * Sample Input:
 *
 * 5
 * 3 1
 * 3 2
 * 2 4
 * 2 5
 * 1 1 2 2 1
 * 4
 * 3
 * 1
 * 2
 * 4
 *
 * Output:
 * 2
 * 1
 * 1
 * 1
 *
 * My Output:
 * 2
 * 1
 * 1
 * 1
 *
 *
 * Sample Tree Visualization:
 *
 *    3(2) --> 1(1)
 *    |
 *    v
 *    2(1) --> 4(2)
 *    |
 *    v
 *    5(1)
 *Color of node shown in brackets
 *
 * My Understanding of the question :
 * Problems statement in simple terms:
 * Given a tree where a node is of type (num,color)
 * When queried
 * Tell the number of nodes having same color in subtree.
 * */

class Witch {

    private int n,num_of_attacks,s;
    private static int count;
    private static int[] parent;
    private static Map<Integer,ArrayList<TreeNode>> m;
    private int[] color,x,y;


    public void solve(int testNumber, InputReader in, PrintWriter out) {
        m = new HashMap<>();
        n = in.nextInt();
        color = new int[n+1];
        x = new int[n];
        y = new int[n];
        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            if(i==n){
                for(int j=0;j<n;j++)
                    color[j] = in.nextInt();
                //System.out.println(color.toString());
            }else{
                //System.out.println(i);
                x[i] = in.nextInt();
                y[i] = in.nextInt();
                if(i == 1) {
                    parent[x[i]] = x[i];
                }else{
                    parent[y[i]] = x[i];
                }
            }
        }


        // Construct Tree
        for(int i=1;i<n;i++){

            addToMap(x[i],y[i]);
            //addToMap(y[i],x[i]);

        }

        /*
            Iterator it = m.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry pair = (Map.Entry) it.next();
                it.remove();
            }
        */

        /*
            for (int i=1;i<=n;i++){
                System.out.println(i+" "+parent[i]);
            }
        */

        num_of_attacks = in.nextInt();
        while (num_of_attacks-- > 0){
            s = in.nextInt();
            boolean[] visited = new boolean[n+1];
            Arrays.fill(visited,false);
            count = 1;
            DFS(s,visited,color[s]);
            System.out.println(count);
        }

    }

    private void addToMap(int x, int y){
        if(m.containsKey(x)){
            m.get(x).add(new TreeNode(y,color[y]));
        }else{
            ArrayList<TreeNode> l = new ArrayList<>();
            l.add(new TreeNode(y,color[y]));
            m.put(x,l);
        }
    }

    private void DFS(int s,boolean[] visited,int color){
        visited[s] = true;
        ArrayList<TreeNode> l;
        if(m.containsKey(s)) {
            l = m.get(s);
        } else{
            return ;
        }
        if(l!=null) {
            Iterator it = l.iterator();
            while (it.hasNext()) {
                TreeNode n = (TreeNode) it.next();
                if (n.color == color)
                    count++;
                if(!visited[n.num]){
                    DFS(n.num,visited,color);
                }
            }
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