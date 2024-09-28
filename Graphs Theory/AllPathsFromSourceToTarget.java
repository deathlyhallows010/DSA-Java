import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                visited[curr] = true;
                modifiedDFS(graph, e.dest, visited, path + e.dest, t);
                visited[curr] = false;
            }
        }
    }

    static void bfsAllPath(List<Edge> graph[], int src, int targ) {
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> path = new ArrayList<>();

        path.add(src);
        q.offer(path);

        while (!q.isEmpty()) {
            path = q.poll();
            int last = path.get(path.size() - 1);

            if (last == targ) {
                printPath(path);
            }

            for (int i = 0; i < graph[last].size(); i++) {
                Edge e = graph[last].get(i);
                if (isNotVisited(e.dest, path)) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(e.dest);
                    q.offer(newPath);
                }
            }
        }
    }

    private static void printPath(List<Integer> path) {
        for (Integer v : path) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    private static boolean isNotVisited(int x, List<Integer> path) {
        int size = path.size();
        for (int i = 0; i < size; i++) {
            if (path.get(i) == x) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
