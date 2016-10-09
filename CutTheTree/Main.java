package Graph;/*
    Coder : lordzuko
    Time  : 9:38 PM
    Date  : 10/8/2016
    
*/

import javafx.util.Pair;

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
        CutTheTree solver = new CutTheTree();
        int n = 1;
        solver.solve(n, in, out);
        out.close();
        System.exit(0);
    }
}

class Edge{
    int u,v;
    public Edge(int u,int v){
        this.u = u;
        this.v = v;
    }
}

class CutTheTree {

    private int n,u,v,total;
    ArrayList<Edge> edges;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        total=0;
        Graph g = new Graph(n);
        for (int i = 1; i < n+1; i++) {
            g.W[i] = in.nextInt();
            total+=g.W[i];
        }
        g.sumTree = Arrays.copyOf(g.W,n+1);
        edges = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            u = in.nextInt();
            v = in.nextInt();
            edges.add(new Edge(u,v));
            g.addEdge(u,v);
        }

//        System.out.println("-------------------------");
//        System.out.println("Printing W");
//        for (int i = 1; i < n+1; i++) {
//            System.out.println(i+ " -> " + g.W[i]);
//        }
//        System.out.println("-------------------------");
//        System.out.println("Printing sumTree Initial");
//        for (int i = 1; i < n+1; i++) {
//            System.out.println(i+ " -> " + g.sumTree[i]);
//        }
//        System.out.println("-------------------------");

        g.DFS(1);
//        System.out.println("Printing sumTree Final");
//        for(int i=1;i<n+1;i++){
//            System.out.println(i+ "-> " + g.sumTree[i]);
//        }
//        System.out.println("-------------------------");
//
//        Iterator it  = g.adj.entrySet().iterator();
//
//        System.out.println("Printing Tree");
//        while(it.hasNext()){
//            Map.Entry pair = (Map.Entry)it.next();
//            System.out.println(pair.getKey() + " = " + pair.getValue());
//            it.remove();
//        }
//        System.out.println("-------------------------");

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n-1 ; i++) {
            u = edges.get(i).u;
            v = edges.get(i).v;
            min = Math.min(min,Math.abs(total-2*(Math.min(g.sumTree[u],g.sumTree[v]))));
        }
        System.out.println(min);
    }
}

class Graph{
    int V;
    int[] W;
    HashMap<Integer,ArrayList<Integer>> adj;
    static int[] sumTree; // sum of sub tree rooted at index i

    public Graph(int V){
        this.V = V;
        W = new int[V+1];
        this.adj = new HashMap<>();
        //this.sumTree = new int[V+1];
    }

    public void addEdge(int u,int v){
        if(adj.containsKey(u)){
                adj.get(u).add(v);
        } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(v);
                adj.put(u, l);
        }

        if(adj.containsKey(v)){
            adj.get(v).add(u);
        } else {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(u);
            adj.put(v, l);
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
                sumTree[v] += sumTree[n];
            }

            //System.out.println(v + "-" + n + "=> "+ sumTree[v]);
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