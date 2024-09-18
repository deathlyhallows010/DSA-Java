import java.util.ArrayList;

public class AllPathsFromSourceToTarget {
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

    static void modifiedDFS(ArrayList<Edge> graph[], int curr, boolean visited[], String path, int t) {

        if (t == curr) {
            System.out.println(path);
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visited[e.dest] != true) {
                path += graph[curr].get(i).dest;
                visited[curr] = true;
                modifiedDFS(graph, e.dest, visited, path, t);
                visited[curr] = false;
            }
        }

    }

    public static void main(String[] args) {

    }
}
