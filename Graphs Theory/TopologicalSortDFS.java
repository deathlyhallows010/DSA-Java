import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS{

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

    public static void DFSTopologicalSort(ArrayList<Edge> graph[], boolean visisted[], int curr, Stack<Integer> stack){
        visisted[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visisted[e.dest]){
                DFSTopologicalSort(graph, visisted, e.dest, stack);
            }
        }
        stack.push(curr);
    }
    public static void main(String[] args) {    
        // Directed and non Cyclic (DAG)
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                DFSTopologicalSort(graph, visited, 0, stack);
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}