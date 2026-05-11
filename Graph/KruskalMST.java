package Graph;

import java.util.ArrayList;
import java.util.Collections;

/*
--------------------------------------------------
Data Structure: Kruskal Minimum Spanning Tree

Description:
Kruskal Algorithm finds Minimum
Spanning Tree using:

1. Greedy Algorithm
2. Union Find (DSU)

Applications:
- Network Design
- Cable Routing
- Electrical Systems

Operations:
1. Add Edge
2. Display Graph
3. Kruskal MST
4. Find Parent
5. Union Sets
6. Display MST
7. Total MST Weight

Time Complexity:
O(E log E)

Space Complexity:
O(V + E)
--------------------------------------------------
*/

public class KruskalMST {

    /*
    --------------------------------------------------
    Edge Class
    --------------------------------------------------
    */

    class Edge implements Comparable<Edge> {

        int source;
        int destination;
        int weight;

        Edge(int source,
             int destination,
             int weight) {

            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        // Sort edges by weight
        public int compareTo(Edge other) {

            return this.weight - other.weight;
        }
    }

    int vertices;

    ArrayList<Edge> edges;

    // Constructor
    KruskalMST(int vertices) {

        this.vertices = vertices;

        edges = new ArrayList<>();
    }

    /*
    --------------------------------------------------
    1. Add Edge
    --------------------------------------------------
    */

    void addEdge(int source,
                 int destination,
                 int weight) {

        edges.add(
                new Edge(source,
                        destination,
                        weight));
    }

    /*
    --------------------------------------------------
    2. Display Graph
    --------------------------------------------------
    */

    void show() {

        for (Edge edge : edges) {

            System.out.println(
                    edge.source
                    + " -> "
                    + edge.destination
                    + " : "
                    + edge.weight);
        }
    }

    /*
    --------------------------------------------------
    3. Find Parent (DSU)
    --------------------------------------------------
    */

    int find(int[] parent,
             int vertex) {

        // Step 1: Find root parent
        if (parent[vertex] != vertex) {

            parent[vertex]
                    = find(parent,
                    parent[vertex]);
        }

        return parent[vertex];
    }

    /*
    --------------------------------------------------
    4. Union Sets
    --------------------------------------------------
    */

    void union(int[] parent,
               int x,
               int y) {

        int rootX = find(parent, x);

        int rootY = find(parent, y);

        parent[rootX] = rootY;
    }

    /*
    --------------------------------------------------
    5. Kruskal MST
    --------------------------------------------------
    */

    void kruskalMST() {

        // Step 1: Sort edges
        Collections.sort(edges);

        // Step 2: Create parent array
        int[] parent =
                new int[vertices];

        // Step 3: Initialize parent
        for (int i = 0; i < vertices; i++) {

            parent[i] = i;
        }

        int totalWeight = 0;

        System.out.println(
                "\nEdges in MST:");

        // Step 4: Process edges
        for (Edge edge : edges) {

            int rootSource =
                    find(parent,
                            edge.source);

            int rootDestination =
                    find(parent,
                            edge.destination);

            // No cycle
            if (rootSource
                    != rootDestination) {

                System.out.println(
                        edge.source
                        + " -> "
                        + edge.destination
                        + " : "
                        + edge.weight);

                totalWeight += edge.weight;

                union(parent,
                        rootSource,
                        rootDestination);
            }
        }

        // Step 5: Print total weight
        System.out.println(
                "\nTotal MST Weight: "
                + totalWeight);
    }

    /*
    --------------------------------------------------
    6. Count Vertices
    --------------------------------------------------
    */

    int countVertices() {

        return vertices;
    }

    /*
    --------------------------------------------------
    7. Count Edges
    --------------------------------------------------
    */

    int countEdges() {

        return edges.size();
    }
}