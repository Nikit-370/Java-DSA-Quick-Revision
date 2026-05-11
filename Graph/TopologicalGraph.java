package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
--------------------------------------------------
Data Structure: Topological Sort Graph

Description:
Topological Sorting gives linear ordering
of vertices in Directed Acyclic Graph (DAG).

Applications:
- Task Scheduling
- Dependency Resolution
- Build Systems
- Course Scheduling

Operations:
1. Add Directed Edge
2. Display Graph
3. Topological Sort
4. Calculate Indegree
5. BFS Traversal
6. DFS Traversal
7. Search Vertex
8. Count Vertices
9. Count Edges
10. Detect Cycle

Time Complexity:
Topological Sort : O(V + E)

Space Complexity:
O(V + E)
--------------------------------------------------
*/

public class TopologicalGraph {

    int vertices;

    ArrayList<ArrayList<Integer>> graph;

    // Constructor
    TopologicalGraph(int vertices) {

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
    1. Add Directed Edge
    --------------------------------------------------
    */

    void addEdge(int source,
                 int destination) {

        graph.get(source)
                .add(destination);
    }

    /*
    --------------------------------------------------
    2. Display Graph
    --------------------------------------------------
    */

    void show() {

        for (int i = 0; i < vertices; i++) {

            System.out.print(i + " -> ");

            for (int neighbor :
                    graph.get(i)) {

                System.out.print(
                        neighbor + " ");
            }

            System.out.println();
        }
    }

    /*
    --------------------------------------------------
    3. Calculate Indegree
    --------------------------------------------------
    */

    int[] calculateIndegree() {

        int[] indegree =
                new int[vertices];

        // Step 1: Traverse graph
        for (int i = 0; i < vertices; i++) {

            for (int neighbor :
                    graph.get(i)) {

                indegree[neighbor]++;
            }
        }

        return indegree;
    }

    /*
    --------------------------------------------------
    4. Topological Sort
    --------------------------------------------------
    */

    void topologicalSort() {

        // Step 1: Calculate indegree
        int[] indegree =
                calculateIndegree();

        // Step 2: Create queue
        Queue<Integer> queue =
                new LinkedList<>();

        // Step 3: Add zero indegree vertices
        for (int i = 0; i < vertices; i++) {

            if (indegree[i] == 0) {

                queue.add(i);
            }
        }

        System.out.print(
                "Topological Order: ");

        int count = 0;

        // Step 4: Process queue
        while (!queue.isEmpty()) {

            int current =
                    queue.remove();

            System.out.print(
                    current + " ");

            count++;

            // Reduce indegree
            for (int neighbor :
                    graph.get(current)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {

                    queue.add(neighbor);
                }
            }
        }

        // Step 5: Detect cycle
        if (count != vertices) {

            System.out.println(
                    "\nGraph contains cycle");
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

            int current =
                    queue.remove();

            System.out.print(
                    current + " ");

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
    6. DFS Traversal
    --------------------------------------------------
    */

    void dfs(int start) {

        boolean[] visited =
                new boolean[vertices];

        dfsHelper(start, visited);
    }

    // DFS Helper
    void dfsHelper(int vertex,
                   boolean[] visited) {

        visited[vertex] = true;

        System.out.print(
                vertex + " ");

        for (int neighbor :
                graph.get(vertex)) {

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

        return count;
    }

    /*
    --------------------------------------------------
    10. Detect Cycle
    --------------------------------------------------
    */

    boolean hasCycle() {

        int[] indegree =
                calculateIndegree();

        Queue<Integer> queue =
                new LinkedList<>();

        for (int i = 0; i < vertices; i++) {

            if (indegree[i] == 0) {

                queue.add(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {

            int current =
                    queue.remove();

            count++;

            for (int neighbor :
                    graph.get(current)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {

                    queue.add(neighbor);
                }
            }
        }

        return count != vertices;
    }
}