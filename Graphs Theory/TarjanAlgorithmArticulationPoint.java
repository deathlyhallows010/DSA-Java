import java.util.ArrayList;

public class TarjanAlgorithmArticulationPoint {

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

    // O(V+E)

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], int time,
            boolean ap[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if (neigh == par) {
                continue;
            } else if (vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfs(graph, e.dest, curr, dt, low, vis, time, ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (dt[curr] <= low[neigh] && par != -1) {
                    ap[curr] = true;
                }
                children++;
            }
        }
        if (par == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time, ap);
            }
        }
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println("AP: "+i);
            }
        }

    }

    public static void main(String[] args) {

        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        getAP(graph, V);

    }
}
