import java.util.ArrayList;

public class TarjansAlgorithmBridge {

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

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[], int dt[], int low[], int time, int par) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dest == par) {
                continue;
            } else if (!vis[e.dest]) {
                dfs(graph, e.dest, vis, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (dt[curr] < low[e.dest]) {
                    System.out.println("bridge is : " + curr + "-----------" + e.dest);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    public static void getBridge(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];
        int time = 0;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, dt, low, time, -1);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        getBridge(graph, V);

    }
}
