package Graph;

public class FloydWarshallDriver {

    public static void main(String[] args) {

        // Step 1: Create graph
        FloydWarshall graph =
                new FloydWarshall(4);

        // --------------------------------------------------
        // 1. Add Edges
        // --------------------------------------------------

        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 3, 10);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);

        // --------------------------------------------------
        // 2. Display Adjacency Matrix
        // --------------------------------------------------

        System.out.println("Adjacency Matrix:");

        graph.show();

        // --------------------------------------------------
        // 3. Floyd Warshall Algorithm
        // --------------------------------------------------

        graph.floydWarshall();
    }
}