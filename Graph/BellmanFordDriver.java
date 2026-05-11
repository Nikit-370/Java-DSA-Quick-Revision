package Graph;

public class BellmanFordDriver {

    public static void main(String[] args) {

        // Step 1: Create graph
        BellmanFord graph =
                new BellmanFord(5);

        // --------------------------------------------------
        // 1. Add Edges
        // --------------------------------------------------

        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);

        // --------------------------------------------------
        // 2. Display Graph
        // --------------------------------------------------

        System.out.println("Graph Edges:");

        graph.show();

        // --------------------------------------------------
        // 3. Bellman Ford Algorithm
        // --------------------------------------------------

        graph.bellmanFord(0);
    }
}