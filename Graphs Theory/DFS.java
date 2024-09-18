import java.util.ArrayList;
import java.util.Stack;

public class DFS {
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

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.println(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] == false) {
                dfs(graph, e.dest, vis);
            }

        }
    }

    public static void dfsStack(ArrayList<Edge> graph[], int src) {
        boolean[] visisted = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        
        stack.push(src);
        
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (visisted[curr] != true) {
                System.out.println(curr + " ");
                visisted[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    if (visisted[e.dest] == false) {
                        stack.add(e.dest);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);

        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                dfs(graph, i, vis);
            }
        }
    }
}
