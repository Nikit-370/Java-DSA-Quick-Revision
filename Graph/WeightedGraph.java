package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

/*
--------------------------------------------------
Data Structure: Weighted Graph

Description:
A Weighted Graph stores weights
with edges.

Applications:
- GPS
- Network Routing
- Shortest Path Problems

Operations:
1. Add Weighted Edge
2. Display Graph
3. Dijkstra Shortest Path
4. BFS Traversal
5. DFS Traversal
6. Search Vertex
7. Count Vertices
8. Count Edges
9. Remove Edge
10. Print Distances

Time Complexity:
Dijkstra : O(E log V)

Space Complexity:
O(V + E)
--------------------------------------------------
*/

public class WeightedGraph {

    /*
    --------------------------------------------------
    Edge Class
    --------------------------------------------------
    */

    class Edge {

        int destination;
        int weight;

        Edge(int destination, int weight) {

            this.destination = destination;

            this.weight = weight;
        }
    }

    /*
    --------------------------------------------------
    Pair Class For Priority Queue
    --------------------------------------------------
    */

    class Pair implements Comparable<Pair> {

        int vertex;
        int distance;

        Pair(int vertex, int distance) {

            this.vertex = vertex;

            this.distance = distance;
        }

        // Compare distances
        public int compareTo(Pair other) {

            return this.distance - other.distance;
        }
    }

    int vertices;

    ArrayList<ArrayList<Edge>> graph;

    // Constructor
    WeightedGraph(int vertices) {

        // Step 1: Initialize vertices
        this.vertices = vertices;

        // Step 2: Create adjacency list
        graph = new ArrayList<>();

        // Step 3: Create list for each vertex
        for (int i = 0; i < vertices; i++) {

            graph.add(new ArrayList<>());
        }
    }

    /*
    --------------------------------------------------
    1. Add Weighted Edge
    --------------------------------------------------
    */

    void addEdge(int source,
                 int destination,
                 int weight) {

        graph.get(source)
                .add(new Edge(destination,
                        weight));

        graph.get(destination)
                .add(new Edge(source,
                        weight));
    }

    /*
    --------------------------------------------------
    2. Display Graph
    --------------------------------------------------
    */

    void show() {

        for (int i = 0; i < vertices; i++) {

            System.out.print(i + " -> ");

            for (Edge edge : graph.get(i)) {

                System.out.print(
                        "("
                        + edge.destination
                        + ", "
                        + edge.weight
                        + ") ");
            }

            System.out.println();
        }
    }

    /*
    --------------------------------------------------
    3. Dijkstra Shortest Path
    --------------------------------------------------
    */

    int[] dijkstra(int source) {

        // Step 1: Create distance array
        int[] distance =
                new int[vertices];

        // Step 2: Initialize infinity
        for (int i = 0; i < vertices; i++) {

            distance[i] = Integer.MAX_VALUE;
        }

        // Step 3: Distance to source = 0
        distance[source] = 0;

        // Step 4: Create priority queue
        PriorityQueue<Pair> pq =
                new PriorityQueue<>();

        pq.add(new Pair(source, 0));

        // Step 5: Traverse graph
        while (!pq.isEmpty()) {

            Pair current = pq.remove();

            int currentVertex =
                    current.vertex;

            // Visit neighbors
            for (Edge edge :
                    graph.get(currentVertex)) {

                int neighbor =
                        edge.destination;

                int weight =
                        edge.weight;

                // Relaxation
                if (distance[currentVertex]
                        + weight
                        < distance[neighbor]) {

                    distance[neighbor]
                            = distance[currentVertex]
                            + weight;

                    pq.add(new Pair(
                            neighbor,
                            distance[neighbor]));
                }
            }
        }

        return distance;
    }

    /*
    --------------------------------------------------
    4. Print Distances
    --------------------------------------------------
    */

    void printDistances(int[] distance) {

        for (int i = 0; i < distance.length; i++) {

            System.out.println(
                    "Vertex "
                    + i
                    + " -> Distance = "
                    + distance[i]);
        }
    }

    /*
    --------------------------------------------------
    5. BFS Traversal
    --------------------------------------------------
    */

    void bfs(int start) {

        boolean[] visited =
                new boolean[vertices];

        Queue<Integer> queue =
                new LinkedList<>();

        visited[start] = true;

        queue.add(start);

        while (!queue.isEmpty()) {

            int current = queue.remove();

            System.out.print(current + " ");

            for (Edge edge :
                    graph.get(current)) {

                int neighbor =
                        edge.destination;

                if (!visited[neighbor]) {

                    visited[neighbor] = true;

                    queue.add(neighbor);
                }
            }
        }
    }

    /*
    --------------------------------------------------
    6. DFS Traversal
    --------------------------------------------------
    */

    void dfs(int start) {

        boolean[] visited =
                new boolean[vertices];

        dfsHelper(start, visited);
    }

    // DFS Helper Method
    void dfsHelper(int vertex,
                   boolean[] visited) {

        visited[vertex] = true;

        System.out.print(vertex + " ");

        for (Edge edge :
                graph.get(vertex)) {

            int neighbor =
                    edge.destination;

            if (!visited[neighbor]) {

                dfsHelper(neighbor,
                        visited);
            }
        }
    }

    /*
    --------------------------------------------------
    7. Search Vertex
    --------------------------------------------------
    */

    boolean search(int vertex) {

        return vertex >= 0
                && vertex < vertices;
    }

    /*
    --------------------------------------------------
    8. Count Vertices
    --------------------------------------------------
    */

    int countVertices() {

        return vertices;
    }

    /*
    --------------------------------------------------
    9. Count Edges
    --------------------------------------------------
    */

    int countEdges() {

        int count = 0;

        for (int i = 0; i < vertices; i++) {

            count += graph.get(i).size();
        }

        return count / 2;
    }

    /*
    --------------------------------------------------
    10. Remove Edge
    --------------------------------------------------
    */

    void removeEdge(int source,
                    int destination) {

        graph.get(source).removeIf(
                edge ->
                        edge.destination
                                == destination);

        graph.get(destination).removeIf(
                edge ->
                        edge.destination
                                == source);
    }
}