public class AdjacencyMatrix {

    private boolean[][] adjacencyMatrix;
    @SuppressWarnings("unused")
    private int numVertices;

    public AdjacencyMatrix(int numVertices){
        this.numVertices = numVertices;
        this.adjacencyMatrix = new boolean[numVertices][numVertices];
    }

    public void addEdges(int i, int j){
        adjacencyMatrix[i][j] = true;
        adjacencyMatrix[j][i] = true;
    }

    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix(4);

        graph.addEdges(0, 1);
        graph.addEdges(1, 2);
        graph.addEdges(2, 0);
        graph.addEdges(1, 3);
    }
}
