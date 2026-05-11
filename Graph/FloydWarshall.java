package Graph;

/*
--------------------------------------------------
Algorithm: Floyd Warshall Algorithm

Description:
Floyd Warshall Algorithm finds shortest
paths between ALL pairs of vertices.

Works on:
- Weighted Graphs
- Directed Graphs

Can detect:
- Negative Weight Cycles

Operations:
1. Add Edge
2. Display Matrix
3. Floyd Warshall Algorithm
4. Print Shortest Paths
5. Detect Negative Cycle

Time Complexity:
O(V^3)

Space Complexity:
O(V^2)
--------------------------------------------------
*/

public class FloydWarshall {

    int vertices;

    int[][] graph;

    static final int INF = 99999;

    // Constructor
    FloydWarshall(int vertices) {

        this.vertices = vertices;

        graph = new int[vertices][vertices];

        // Step 1: Initialize matrix
        for (int i = 0; i < vertices; i++) {

            for (int j = 0; j < vertices; j++) {

                if (i == j) {

                    graph[i][j] = 0;
                }

                else {

                    graph[i][j] = INF;
                }
            }
        }
    }

    /*
    --------------------------------------------------
    1. Add Edge
    --------------------------------------------------
    */

    void addEdge(int source,
                 int destination,
                 int weight) {

        graph[source][destination]
                = weight;
    }

    /*
    --------------------------------------------------
    2. Display Matrix
    --------------------------------------------------
    */

    void show() {

        for (int i = 0; i < vertices; i++) {

            for (int j = 0; j < vertices; j++) {

                if (graph[i][j] == INF) {

                    System.out.print(
                            "INF ");
                }

                else {

                    System.out.print(
                            graph[i][j]
                            + " ");
                }
            }

            System.out.println();
        }
    }

    /*
    --------------------------------------------------
    3. Floyd Warshall Algorithm
    --------------------------------------------------
    */

    void floydWarshall() {

        // Step 1: Create distance matrix
        int[][] distance =
                new int[vertices][vertices];

        // Step 2: Copy graph matrix
        for (int i = 0; i < vertices; i++) {

            for (int j = 0; j < vertices; j++) {

                distance[i][j]
                        = graph[i][j];
            }
        }

        // Step 3: Main algorithm
        for (int k = 0; k < vertices; k++) {

            for (int i = 0; i < vertices; i++) {

                for (int j = 0; j < vertices; j++) {

                    // Relaxation
                    if (distance[i][k]
                            + distance[k][j]
                            <
                            distance[i][j]) {

                        distance[i][j]
                                =
                                distance[i][k]
                                + distance[k][j];
                    }
                }
            }
        }

        /*
        --------------------------------------------------
        4. Detect Negative Cycle
        --------------------------------------------------
        */

        for (int i = 0; i < vertices; i++) {

            if (distance[i][i] < 0) {

                System.out.println(
                        "Negative Weight Cycle Detected");

                return;
            }
        }

        // Step 5: Print shortest paths
        printDistances(distance);
    }

    /*
    --------------------------------------------------
    5. Print Shortest Paths
    --------------------------------------------------
    */

    void printDistances(int[][] distance) {

        System.out.println(
                "\nShortest Path Matrix:");

        for (int i = 0; i < vertices; i++) {

            for (int j = 0; j < vertices; j++) {

                if (distance[i][j] == INF) {

                    System.out.print(
                            "INF ");
                }

                else {

                    System.out.print(
                            distance[i][j]
                            + " ");
                }
            }

            System.out.println();
        }
    }
}