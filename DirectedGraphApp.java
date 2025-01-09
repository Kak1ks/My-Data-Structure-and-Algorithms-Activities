import java.util.*;

class DirectedGraph {
    // A Map to store the graph using adjacency list
    private Map<String, List<String>> adjList;

    // Constructor to initialize the graph
    public DirectedGraph() {
        adjList = new HashMap<>();
}

    // Add a vertex to the graph
    public void addVertex(String vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add a directed edge from vertex1 to vertex2
    public void addEdge(String vertex1, String vertex2) {
        adjList.putIfAbsent(vertex1, new ArrayList<>());
        adjList.putIfAbsent(vertex2, new ArrayList<>());
        adjList.get(vertex1).add(vertex2);
   }

    // Perform DFS starting from a vertex
    public void dfs(String startVertex) {
        Set<String> visited = new HashSet<>();
        System.out.println("DFS Traversal starting from " + startVertex + ": ");
        dfsHelper(startVertex, visited);
        System.out.println(); // For a new line after DFS traversal
    }

    // Helper method for DFS
    private void dfsHelper(String vertex, Set<String> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        // Recur for all adjacent vertices
        for (String neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
    }
    }

    // Display the graph
    public void displayGraph() {
        for (String vertex : adjList.keySet()) {
            System.out.print(vertex + " -> ");
            for (String neighbor : adjList.get(vertex)) {
                System.out.print(neighbor + " ");
           }
            System.out.println();
 }
  }
}

public class DirectedGraphApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectedGraph graph = new DirectedGraph();

        // Menu-driven console application
        while (true) {
            System.out.println("\nDirected Graph Operations:");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. DFS Traversal");
            System.out.println("4. Display Graph");
            System.out.println("5. Exit");
           System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter vertex name: ");
                    String vertex = scanner.nextLine();
                    graph.addVertex(vertex);
                    System.out.println("Vertex added: " + vertex);
                    break;

                case 2:
                    System.out.print("Enter the source vertex: ");
                    String vertex1 = scanner.nextLine();
                    System.out.print("Enter the destination vertex: ");
                    String vertex2 = scanner.nextLine();
                    graph.addEdge(vertex1, vertex2);
                    System.out.println("Edge added from " + vertex1 + " to " + vertex2);
                    break;
                case 3:
                    System.out.print("Enter starting vertex for DFS: ");
                    String startVertex = scanner.nextLine();
                    graph.dfs(startVertex);
                    break;

                case 4:
                    System.out.println("Graph:");
                    graph.displayGraph();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
       }
    }
}
}
