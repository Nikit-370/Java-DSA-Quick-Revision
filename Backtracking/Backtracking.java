package Backtracking;

/*
--------------------------------------------------
Concept: Backtracking

Description:
Backtracking is an algorithmic technique used
to solve problems by trying all possible
solutions and removing invalid choices.

Steps:
1. Choose
2. Explore
3. Undo (Backtrack)

Applications:
- Maze Problems
- Sudoku Solver
- N Queens
- Permutations

Time Complexity:
Depends on number of choices

Space Complexity:
Depends on recursion stack
--------------------------------------------------
*/

public class Backtracking {

    // Print numbers using backtracking
    void printNumbers(int n) {

        // Step 1: Create visited array
        boolean[] visited = new boolean[n + 1];

        // Step 2: Start backtracking
        backtrack(1, n, visited);
    }

    // Backtracking method
    void backtrack(int current, int n, boolean[] visited) {

        // Step 1: Base condition
        if (current > n) {
            return;
        }

        // Step 2: Choose
        visited[current] = true;

        // Step 3: Process current value
        System.out.print(current + " ");

        // Step 4: Explore next choice
        backtrack(current + 1, n, visited);

        // Step 5: Undo choice (Backtrack)
        visited[current] = false;
    }

    // Generate binary sequence
    void binarySequence(int n) {

        // Step 1: Create array
        int[] arr = new int[n];

        // Step 2: Start recursion
        generateBinary(arr, 0, n);
    }

    // Recursive binary generator
    void generateBinary(int[] arr, int index, int n) {

        // Step 1: Base condition
        if (index == n) {

            // Step 2: Print sequence
            for (int value : arr) {
                System.out.print(value);
            }

            System.out.println();
            return;
        }

        // Step 3: Choose 0
        arr[index] = 0;

        // Step 4: Explore
        generateBinary(arr, index + 1, n);

        // Step 5: Choose 1
        arr[index] = 1;

        // Step 6: Explore
        generateBinary(arr, index + 1, n);
    }
}