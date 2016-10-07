package DataStructures.SegmentTree;

import java.util.*;

/**
 * Created by hmaurya on 9/25/2016.
 */
public class Graph {

    private int V;
    private HashMap<Integer,ArrayList<Integer>> adj;
    Graph(int V){
        this.V = V;
        this.adj = new HashMap<>();
    }

    public void addEdge(int u,int v){
        if(adj.containsKey(u)){
            adj.get(u).add(v);
        }else{
            ArrayList<Integer> l = new ArrayList<>();
            l.add(v);
            adj.put(u,l);
        }
    }

    private void DFSUtil(int v,boolean[] visited){
        visited[v] = true;
        System.out.println(v+" ");
        Iterator it = adj.get(v).iterator();
        while(it.hasNext()){
            int n = Integer.parseInt(it.next().toString());
            if(!visited[n]){
                DFSUtil(n,visited);
            }
        }
    }

    public void DFS(int v){
        boolean[] visited = new boolean[V];
        Arrays.fill(visited,false);

        DFSUtil(v,visited);

    }


    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
    }
}
