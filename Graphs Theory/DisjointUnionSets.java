class DisjointUnionSets {
    int[] rank, parent;
    int n;

    public DisjointUnionSets(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Parent of self
        }
    }

    // int find(int x) {
    //     if (parent[x] == x) {
    //         return x;
    //     }
    //     return find(parent[x]);
    // }

    // Path Compression
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }


    // void union(int x, int y){
    // int xpar = find(x);
    // int ypar = find(y);
    // if(xpar==ypar){
    // return;
    // }
    // parent[y] = x;
    // }

    // union with Rank
    void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            return;
        }
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] += 1;
        }
    }

}
