package Graph;

public class GraphDriver {

    public static void main(String[] args) {

        // Step 1: Create graph
        GraphOperations graph =
                new GraphOperations(6);

        // --------------------------------------------------
        // 1. Add Edges
        // --------------------------------------------------

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        /*
                    0
                   / \
                  1   2
                  |   |
                  3---4
                   \ /
                    5
        */

        // --------------------------------------------------
        // 2. Display Graph
        // --------------------------------------------------

        System.out.println("Graph:");

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

        System.out.println("Search Vertex 10: "
                + graph.search(10));

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
        // 8. Detect Cycle
        // --------------------------------------------------

        System.out.println("Graph Has Cycle: "
                + graph.hasCycle());

        // --------------------------------------------------
        // 9. Check Path
        // --------------------------------------------------

        System.out.println("Path 0 -> 5: "
                + graph.hasPath(0, 5));

        System.out.println("Path 1 -> 4: "
                + graph.hasPath(1, 4));

        // --------------------------------------------------
        // 10. Remove Edge
        // --------------------------------------------------

        graph.removeEdge(3, 5);

        System.out.println("\nGraph After Removing Edge:");

        graph.show();
    }
}