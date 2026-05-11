package Graph;

import java.util.ArrayList;

/*
--------------------------------------------------
Algorithm: Bellman Ford Algorithm

Description:
Bellman Ford Algorithm finds shortest paths
from source vertex to all other vertices.

Works on:
- Weighted Graphs
- Negative Edge Weights

Can also detect:
- Negative Weight Cycles

Operations:
1. Add Edge
2. Display Graph
3. Bellman Ford Shortest Path
4. Print Distances
5. Detect Negative Cycle

Time Complexity:
O(V * E)

Space Complexity:
O(V)
--------------------------------------------------
*/

public class BellmanFord {

    /*
    --------------------------------------------------
    Edge Class
    --------------------------------------------------
    */

    class Edge {

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
    }

    int vertices;

    ArrayList<Edge> edges;

    // Constructor
    BellmanFord(int vertices) {

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

        edges.add(new Edge(
                source,
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
    3. Bellman Ford Algorithm
    --------------------------------------------------
    */

    void bellmanFord(int source) {

        // Step 1: Create distance array
        int[] distance =
                new int[vertices];

        // Step 2: Initialize infinity
        for (int i = 0; i < vertices; i++) {

            distance[i] =
                    Integer.MAX_VALUE;
        }

        // Step 3: Source distance = 0
        distance[source] = 0;

        // Step 4: Relax all edges V-1 times
        for (int i = 1;
             i < vertices;
             i++) {

            for (Edge edge : edges) {

                int u = edge.source;
                int v = edge.destination;
                int w = edge.weight;

                // Relaxation
                if (distance[u]
                        != Integer.MAX_VALUE
                        &&
                        distance[u] + w
                        < distance[v]) {

                    distance[v]
                            = distance[u] + w;
                }
            }
        }

        /*
        --------------------------------------------------
        4. Detect Negative Weight Cycle
        --------------------------------------------------
        */

        for (Edge edge : edges) {

            int u = edge.source;
            int v = edge.destination;
            int w = edge.weight;

            if (distance[u]
                    != Integer.MAX_VALUE
                    &&
                    distance[u] + w
                    < distance[v]) {

                System.out.println(
                        "Negative Weight Cycle Detected");

                return;
            }
        }

        // Step 5: Print shortest distances
        printDistances(distance);
    }

    /*
    --------------------------------------------------
    5. Print Distances
    --------------------------------------------------
    */

    void printDistances(int[] distance) {

        System.out.println(
                "\nShortest Distances:");

        for (int i = 0; i < vertices; i++) {

            System.out.println(
                    "Vertex "
                    + i
                    + " -> "
                    + distance[i]);
        }
    }
}