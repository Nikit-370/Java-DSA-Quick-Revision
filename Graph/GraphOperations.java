package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
--------------------------------------------------
Data Structure: Graph

Description:
A Graph is a non-linear data structure
consisting of:

1. Vertices (Nodes)
2. Edges (Connections)

Types:
- Directed Graph
- Undirected Graph
- Weighted Graph

Representation:
Adjacency List

Operations:
1. Add Edge
2. Display Graph
3. BFS Traversal
4. DFS Traversal
5. Search Vertex
6. Count Vertices
7. Count Edges
8. Detect Cycle
9. Remove Edge
10. Check Path

Time Complexity:
Add Edge : O(1)
BFS      : O(V + E)
DFS      : O(V + E)

Space Complexity:
O(V + E)
--------------------------------------------------
*/

public class GraphOperations {

    int vertices; // Step 1: Number of vertices

    ArrayList<ArrayList<Integer>> graph;

    // Constructor
    GraphOperations(int vertices) {

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
    1. Add Edge
    --------------------------------------------------
    */

    void addEdge(int source, int destination) {

        // Undirected Graph
        graph.get(source).add(destination);

        graph.get(destination).add(source);
    }

    /*
    --------------------------------------------------
    2. Display Graph
    --------------------------------------------------
    */

    void show() {

        // Step 1: Traverse all vertices
        for (int i = 0; i < vertices; i++) {

            System.out.print(i + " -> ");

            // Step 2: Traverse adjacency list
            for (int neighbor : graph.get(i)) {

                System.out.print(neighbor + " ");
            }

            System.out.println();
        }
    }

    /*
    --------------------------------------------------
    3. BFS Traversal
    --------------------------------------------------
    */

    void bfs(int start) {

        // Step 1: Create visited array
        boolean[] visited =
                new boolean[vertices];

        // Step 2: Create queue
        Queue<Integer> queue =
                new LinkedList<>();

        // Step 3: Mark visited
        visited[start] = true;

        // Step 4: Add starting vertex
        queue.add(start);

        // Step 5: Traverse graph
        while (!queue.isEmpty()) {

            // Remove front vertex
            int current = queue.remove();

            System.out.print(current + " ");

            // Visit neighbors
            for (int neighbor :
                    graph.get(current)) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;

                    queue.add(neighbor);
                }
            }
        }
    }

    /*
    --------------------------------------------------
    4. DFS Traversal
    --------------------------------------------------
    */

    void dfs(int start) {

        // Step 1: Create visited array
        boolean[] visited =
                new boolean[vertices];

        // Step 2: Call recursive DFS
        dfsHelper(start, visited);
    }

    // DFS Helper Method
    void dfsHelper(int vertex,
                   boolean[] visited) {

        // Step 1: Mark visited
        visited[vertex] = true;

        // Step 2: Print vertex
        System.out.print(vertex + " ");

        // Step 3: Visit neighbors
        for (int neighbor :
                graph.get(vertex)) {

            if (!visited[neighbor]) {

                dfsHelper(neighbor, visited);
            }
        }
    }

    /*
    --------------------------------------------------
    5. Search Vertex
    --------------------------------------------------
    */

    boolean search(int vertex) {

        // Step 1: Check valid vertex
        return vertex >= 0
                && vertex < vertices;
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

        int count = 0;

        // Step 1: Count adjacency list size
        for (int i = 0; i < vertices; i++) {

            count += graph.get(i).size();
        }

        // Divide by 2 for undirected graph
        return count / 2;
    }

    /*
    --------------------------------------------------
    8. Detect Cycle
    --------------------------------------------------
    */

    boolean hasCycle() {

        // Step 1: Create visited array
        boolean[] visited =
                new boolean[vertices];

        // Step 2: Check all components
        for (int i = 0; i < vertices; i++) {

            if (!visited[i]) {

                if (cycleDFS(i,
                        visited,
                        -1)) {

                    return true;
                }
            }
        }

        return false;
    }

    // Cycle DFS Helper
    boolean cycleDFS(int current,
                     boolean[] visited,
                     int parent) {

        // Step 1: Mark visited
        visited[current] = true;

        // Step 2: Visit neighbors
        for (int neighbor :
                graph.get(current)) {

            // Unvisited neighbor
            if (!visited[neighbor]) {

                if (cycleDFS(neighbor,
                        visited,
                        current)) {

                    return true;
                }
            }

            // Visited neighbor not parent
            else if (neighbor != parent) {

                return true;
            }
        }

        return false;
    }

    /*
    --------------------------------------------------
    9. Remove Edge
    --------------------------------------------------
    */

    void removeEdge(int source,
                    int destination) {

        // Remove edge from source
        graph.get(source)
                .remove(Integer.valueOf(destination));

        // Remove edge from destination
        graph.get(destination)
                .remove(Integer.valueOf(source));
    }

    /*
    --------------------------------------------------
    10. Check Path
    --------------------------------------------------
    */

    boolean hasPath(int source,
                    int destination) {

        // Step 1: Create visited array
        boolean[] visited =
                new boolean[vertices];

        // Step 2: DFS path search
        return pathDFS(source,
                destination,
                visited);
    }

    // Path DFS Helper
    boolean pathDFS(int current,
                    int destination,
                    boolean[] visited) {

        // Destination found
        if (current == destination) {
            return true;
        }

        // Mark visited
        visited[current] = true;

        // Visit neighbors
        for (int neighbor :
                graph.get(current)) {

            if (!visited[neighbor]) {

                if (pathDFS(neighbor,
                        destination,
                        visited)) {

                    return true;
                }
            }
        }

        return false;
    }
}