package Graph;

public class WeightedGraphDriver {

    public static void main(String[] args) {

        // Step 1: Create weighted graph
        WeightedGraph graph =
                new WeightedGraph(6);

        // --------------------------------------------------
        // 1. Add Weighted Edges
        // --------------------------------------------------

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 2);

        // --------------------------------------------------
        // 2. Display Graph
        // --------------------------------------------------

        System.out.println("Weighted Graph:");

        graph.show();

        // --------------------------------------------------
        // 3. BFS Traversal
        // --------------------------------------------------

        System.out.print("\nBFS Traversal: ");

        graph.bfs(0);

        // --------------------------------------------------
        // 4. DFS Traversal
        // --------------------------------------------------

        System.out.print("\nDFS Traversal: ");

        graph.dfs(0);

        // --------------------------------------------------
        // 5. Search Vertex
        // --------------------------------------------------

        System.out.println("\n\nSearch Vertex 4: "
                + graph.search(4));

        // --------------------------------------------------
        // 6. Count Vertices
        // --------------------------------------------------

        System.out.println("Total Vertices: "
                + graph.countVertices());

        // --------------------------------------------------
        // 7. Count Edges
        // --------------------------------------------------

        System.out.println("Total Edges: "
                + graph.countEdges());

        // --------------------------------------------------
        // 8. Dijkstra Algorithm
        // --------------------------------------------------

        int[] distance =
                graph.dijkstra(0);

        System.out.println(
                "\nShortest Distances:");

        graph.printDistances(distance);

        // --------------------------------------------------
        // 9. Remove Edge
        // --------------------------------------------------

        graph.removeEdge(3, 4);

        System.out.println(
                "\nGraph After Removing Edge:");

        graph.show();
    }
}