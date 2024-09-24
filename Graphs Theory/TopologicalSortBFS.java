import java.util.*;

// Kahn's ALgorithm
// At least once vertix with indegree 0 and atleast one outdegree is 0

public class TopologicalSortBFS {

    public static int[] topologicalSort(List<List<Integer>> adj, int V) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[V];
        int index = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            result[index++] = node;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        if (index != V) {
            System.out.println("Graph contains cycle!");
            return new int[0];
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 6;

        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 },
                { 4, 5 }, { 5, 1 }, { 5, 2 } };


        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        System.out.println("Topological sorting of the graph: ");
        int[] result = topologicalSort(adj, n);

        // Displaying result
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}