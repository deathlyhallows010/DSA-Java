import java.util.*;

public class TargetPresentGraph {
    
    private Map<Integer, List<Integer>> adjList; // Adjacency list for the graph
    
    public TargetPresentGraph() {
        adjList = new HashMap<>();
    }
    
    // Add an edge to the graph
    public void addEdge(int src, int dest) {
        adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(src); // For undirected graph
    }
    
    // DFS helper method that returns true if the target is found
    private boolean dfsHelper(int node, int target, Set<Integer> visited) {
        visited.add(node);   // Mark the node as visited
        if (node == target) {
            return true;  // If the current node is the target, return true
        }
        
        // Visit all the neighbors of the current node
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (dfsHelper(neighbor, target, visited)) {
                    return true;  // Return true if the target is found in the recursive call
                }
            }
        }
        
        return false;  // Return false if the target is not found
    }
    
    // Public method to perform DFS search for the target node
    public boolean dfs(int startNode, int targetNode) {
        Set<Integer> visited = new HashSet<>();   // Set to keep track of visited nodes
        return dfsHelper(startNode, targetNode, visited);  // Call the helper method and return the result
    }
    
    // BFS

    public boolean bfs(int startNode, int targetNode) {
        Set<Integer> visited = new HashSet<>();   // Set to keep track of visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS
        
        queue.offer(startNode);  // Add the starting node to the queue
        visited.add(startNode);  // Mark the starting node as visited
        
        // BFS loop
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();  // Dequeue a node
            
            // If we found the target node, return true
            if (currentNode == targetNode) {
                return true;
            }
            
            // Visit all the neighbors of the current node
            for (int neighbor : adjList.getOrDefault(currentNode, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);    // Enqueue the unvisited neighbor
                    visited.add(neighbor);    // Mark it as visited
                }
            }
        }
        
        // If the queue is empty and we haven't found the target, return false
        return false;
    }

    public static void main(String[] args) {
        TargetPresentGraph graph = new TargetPresentGraph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        
        // Search for node 3 starting from node 2
        boolean isFound = graph.dfs(2, 3);
        System.out.println("Is target node found? " + isFound);
        
        // Search for node 4 starting from node 2
        isFound = graph.dfs(2, 4);
        System.out.println("Is target node found? " + isFound);
    }
}
