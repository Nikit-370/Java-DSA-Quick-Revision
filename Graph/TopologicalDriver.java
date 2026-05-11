package Graph;

public class TopologicalDriver {

    public static void main(String[] args) {

        // Step 1: Create graph
        TopologicalGraph graph =
                new TopologicalGraph(6);

        // --------------------------------------------------
        // 1. Add Directed Edges
        // --------------------------------------------------

        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        /*
                5 ---> 2 ---> 3 ---> 1
                 \               ^
                  \             /
                   ---> 0 <--- 4
        */

        // --------------------------------------------------
        // 2. Display Graph
        // --------------------------------------------------

        System.out.println("Directed Graph:");

        graph.show();

        // --------------------------------------------------
        // 3. BFS Traversal
        // --------------------------------------------------

        System.out.print("\nBFS Traversal: ");

        graph.bfs(5);

        // --------------------------------------------------
        // 4. DFS Traversal
        // --------------------------------------------------

        System.out.print("\nDFS Traversal: ");

        graph.dfs(5);

        // --------------------------------------------------
        // 5. Search Vertex
        // --------------------------------------------------

        System.out.println("\n\nSearch Vertex 3: "
                + graph.search(3));

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
        // 9. Topological Sort
        // --------------------------------------------------

        graph.topologicalSort();
    }
}