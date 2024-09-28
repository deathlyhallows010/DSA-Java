import java.util.ArrayList;

public class CycleDetectionDriected {

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

    public static boolean DFSDetectCycle(ArrayList<Edge> graph[], boolean visited[], int curr, boolean rec[]) {
        visited[curr] = true;
        rec[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.dest]) {
                return true;
            } else if (!visited[e.dest]) {
                if (DFSDetectCycle(graph, visited, e.dest, rec)) {
                    return true;
                }
            }
        }
        rec[curr] = false; // remove from call stack
        return false;
    }

    // Kahn Algorithm - BFS Approach for yndirected graph (Topological Sort)    

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph();
        boolean vis[] = new boolean[V];
        boolean rec[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                boolean iscyclic = DFSDetectCycle(graph, vis, 0, rec);
                if (iscyclic) {
                    break;
                }
            }
        }
    }
}
