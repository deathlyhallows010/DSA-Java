import java.util.ArrayList;

public class CycleDetectionUndirected {

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
    public static boolean isCyclicUndirected(ArrayList<Edge> graph[], boolean vis[], int curr, int par){
        vis[curr] = true;
        for(int i = 0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == true && e.dest != par){
                return true;
            } else if(vis[e.dest] == false){
                if(isCyclicUndirected(graph, vis, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        System.out.println(isCyclicUndirected(graph, new boolean[V], 0, -1));
        
    }
    
}
