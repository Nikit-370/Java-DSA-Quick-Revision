package Graph;

public class MSTDriver {

    public static void main(String[] args) {

        // Step 1: Create MST graph
        KruskalMST graph =
                new KruskalMST(6);

        // --------------------------------------------------
        // 1. Add Weighted Edges
        // --------------------------------------------------

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        // --------------------------------------------------
        // 2. Display Graph
        // --------------------------------------------------

        System.out.println("Graph Edges:");

        graph.show();

        // --------------------------------------------------
        // 3. Count Vertices
        // --------------------------------------------------

        System.out.println(
                "\nTotal Vertices: "
                + graph.countVertices());

        // --------------------------------------------------
        // 4. Count Edges
        // --------------------------------------------------

        System.out.println(
                "Total Edges: "
                + graph.countEdges());

        // --------------------------------------------------
        // 5. Kruskal MST
        // --------------------------------------------------

        graph.kruskalMST();
    }
}