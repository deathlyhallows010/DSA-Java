import java.util.ArrayList;

public class BellmanFord {
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

    public static void BellmanFordAlgo(ArrayList<Edge> graph[], int src, int V) {
        int dist[] = new int[V];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int k = 0; k < V - 1; k++) { // O(V)
            // O(E)
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;

                    if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + e.weight) {
                        dist[v] = dist[u] + e.weight;
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        BellmanFordAlgo(graph, 0, V);

    }
}
