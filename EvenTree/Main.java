package Graph;/*
    Coder : lordzuko
    Time  : 8:49 PM
    Date  : 10/12/2016
    
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
        EvenTree solver = new EvenTree();
        //int n = in.nextInt();
        solver.solve(1, in, out);
        out.close();
        System.exit(0);
    }
}

class EvenTree {
    int m, n;
    int ans;
    int x,y;
    ArrayList<Edge> edges;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        Graph g = new Graph(n);
        ans = 0;
        g.nodesInSubTree = new int[n+1];
        Arrays.fill(g.nodesInSubTree,1);
        edges = new ArrayList<>();
        for(int i=0;i<m;i++){
            x = in.nextInt();
            y = in.nextInt();
            edges.add(new Edge(x,y));
            g.addEdge(y,x);
        }

        g.DFS(1);
        for (int i = 1; i <= n; i++) {
            //System.out.println(i+"-->"+g.nodesInSubTree[i]);
            if(g.nodesInSubTree[i]%2 == 0)
                ans++;
        }
        //remove root node 1
        System.out.println(ans-1);
    }
}

class Edge{
    int u,v;
    public Edge(int u,int v){
        this.u = u;
        this.v = v;
    }
}

class Graph{
    int V;
    static int[] nodesInSubTree;

    HashMap<Integer,ArrayList<Integer>> adj;

    public Graph(int V){
        this.V = V;
        this.adj = new HashMap<>();
    }

    public void addEdge(int u,int v){
        if(adj.containsKey(u)){
            adj.get(u).add(v);
        } else {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(v);
            adj.put(u, l);
        }

    }

    private void DFSUtil(int v, boolean[] visited){
        visited[v] = true;
        Iterator it;

        if(adj.containsKey(v)){
            it = adj.get(v).iterator();
        }else{
            return;
        }

        while(it.hasNext()){
            int n =Integer.parseInt(it.next().toString());
            if(!visited[n]){
                DFSUtil(n,visited);
                nodesInSubTree[v]+=nodesInSubTree[n];
            }

        }

    }

    public void DFS(int v){
        boolean[] visited = new boolean[V+1];
        Arrays.fill(visited,false);

        DFSUtil(v,visited);
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