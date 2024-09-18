import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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

    public static void bfs(ArrayList<Edge> graph[], int V, int src) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];
        q.add(src);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr] == false) {
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void disConnectedCompBFS(ArrayList<Edge> graph[], int V) {
        boolean vis[] = new boolean[V];

        for (int j = 0; j < V; j++) {

            if (vis[j] == true) {
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(j);
            while (!q.isEmpty()) {
                int curr = q.remove();
                if (vis[curr] == false) {
                    vis[curr] = true;
                    for (int i = 0; i < graph[curr].size(); i++) {
                        Edge e = graph[curr].get(i);
                        q.add(e.dest);
                    }
                }
            }
        }
    }
}
