import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort{

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
    }
}