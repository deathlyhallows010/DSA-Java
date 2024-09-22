/*
 * Strongly connected component
 * - makes no logical sense for undirected graph
 */

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {

    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        vis[curr] = true;
        System.out.println(curr+" ");

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void kosarajuAlgo(ArrayList<Edge> graph[], int V){

        // 1. 
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topSort(graph, i, vis, s);
            }
        }

        // 2
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transposeGraph[] = new ArrayList[V];
        for(int i =0; i<graph.length;i++){
            vis[i] = false; // just saving space
            transposeGraph[i] = new ArrayList<Edge>();
        }
        for(int i=0;i<V;i++){
            for(int j= 0; j<graph[i].size();j++){
                Edge e = graph[i].get(j); // e.src -> e.dest
                transposeGraph[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        //3
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                dfs(transposeGraph, curr, vis);
                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
        int V = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        kosarajuAlgo(graph, V);
    }
    
}
