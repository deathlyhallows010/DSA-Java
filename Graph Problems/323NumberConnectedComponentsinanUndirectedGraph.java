import java.util.*;

class Solution {

    // BFS

    public int BFScountComponents(int n, int[][] edges) {
        int ans = 0;

        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new List[n];
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < n; ++i)
            if (!seen.contains(i)) {
                bfs(graph, i, seen);
                ++ans;
            }

        return ans;
    }

    private void bfs(List<Integer>[] graph, int node, Set<Integer> seen) {
        Queue<Integer> q = new ArrayDeque<>(Arrays.asList(node));
        seen.add(node);

        while (!q.isEmpty()) {
            final int u = q.poll();
            for (final int v : graph[u])
                if (!seen.contains(v)) {
                    q.offer(v);
                    seen.add(v);
                }
        }
    }

    // DFS

    public int DFScountComponents(int n, int[][] edges) {
        int ans = 0;

        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new List[n];
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < n; ++i)
            if (seen.add(i)) {
                dfs(graph, i, seen);
                ++ans;
            }

        return ans;
    }

    private void dfs(List<Integer>[] graph, int u, Set<Integer> seen) {
        for (final int v : graph[u])
            if (seen.add(v))
                dfs(graph, v, seen);
    }

    // Union Find

    class UnionFind {
        public UnionFind(int n) {
            count = n;
            id = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i)
                id[i] = i;
        }

        public void unionByRank(int u, int v) {
            final int i = find(u);
            final int j = find(v);
            if (i == j)
                return;
            if (rank[i] < rank[j]) {
                id[i] = j;
            } else if (rank[i] > rank[j]) {
                id[j] = i;
            } else {
                id[i] = j;
                ++rank[j];
            }
            --count;
        }

        public int getCount() {
            return count;
        }

        private int count;
        private int[] id;
        private int[] rank;

        private int find(int u) {
            return id[u] == u ? u : (id[u] = find(id[u]));
        }
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            uf.unionByRank(u, v);
        }

        return uf.getCount();
    }
}
