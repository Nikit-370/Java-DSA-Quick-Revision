package DP;

/*
--------------------------------------------------
Concept: 1D Dynamic Programming

Description:
1D DP uses a one-dimensional array to store
previous computed results.

Structure:
dp[i]

Used When:
- Current state depends on previous states
- Single variable changing

Example:
Fibonacci Series

Time Complexity:
O(n)

Space Complexity:
O(n)
--------------------------------------------------
*/

public class DP1D {

    int[] dp;

    // Constructor
    DP1D(int size) {

        // Step 1: Create DP array
        dp = new int[size + 1];

        // Step 2: Initialize with -1
        for (int i = 0; i <= size; i++) {
            dp[i] = -1;
        }
    }

    // Fibonacci using 1D DP
    int fibonacci(int n) {

        // Step 1: Base condition
        if (n <= 1) {
            return n;
        }

        // Step 2: Return stored value
        if (dp[n] != -1) {
            return dp[n];
        }

        // Step 3: Store answer
        dp[n] = fibonacci(n - 1) + fibonacci(n - 2);

        // Step 4: Return result
        return dp[n];
    }

    // Display DP Array
    void show() {

        // Step 1: Traverse array
        for (int value : dp) {

            // Ignore unused values
            if (value != -1) {
                System.out.print(value + " ");
            }
        }
    }
}