package DP;

/*
--------------------------------------------------
Concept: 2D Dynamic Programming

Description:
2D DP uses a matrix/table to store results.

Structure:
dp[i][j]

Used When:
- Problem depends on two changing variables
- String or matrix related problems

Example:
Grid Path Counting

Time Complexity:
O(n * m)

Space Complexity:
O(n * m)
--------------------------------------------------
*/

public class DP2D {

    int[][] dp;

    // Constructor
    DP2D(int rows, int cols) {

        // Step 1: Create 2D DP array
        dp = new int[rows][cols];
    }

    // Count total paths in grid
    int countPaths(int rows, int cols) {

        // Step 1: Fill first row
        for (int i = 0; i < cols; i++) {
            dp[0][i] = 1;
        }

        // Step 2: Fill first column
        for (int i = 0; i < rows; i++) {
            dp[i][0] = 1;
        }

        // Step 3: Fill remaining cells
        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < cols; j++) {

                // Top + Left
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Step 4: Return last cell
        return dp[rows - 1][cols - 1];
    }

    // Display DP table
    void show() {

        // Step 1: Traverse rows
        for (int[] row : dp) {

            // Step 2: Traverse columns
            for (int value : row) {
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }
}