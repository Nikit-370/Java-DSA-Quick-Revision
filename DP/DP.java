package DP;

/*
--------------------------------------------------
Concept: Dynamic Programming (DP)

Description:
Dynamic Programming is an optimization technique
used to solve problems by storing previously
computed results.

Main Approaches:
1. Memoization (Top Down)
2. Tabulation (Bottom Up)

This example uses Fibonacci Series.

Time Complexity:
Memoization: O(n)
Tabulation: O(n)

Space Complexity:
O(n)
--------------------------------------------------
*/

public class DP {

    int[] dp; // Step 1: DP array for storing results

    // Constructor
    DP(int size) {

        // Step 2: Create DP array
        dp = new int[size + 1];

        // Step 3: Initialize with -1
        for (int i = 0; i <= size; i++) {
            dp[i] = -1;
        }
    }

    // Fibonacci using Memoization
    int fibonacciMemo(int n) {

        // Step 1: Base condition
        if (n <= 1) {
            return n;
        }

        // Step 2: Return already calculated value
        if (dp[n] != -1) {
            return dp[n];
        }

        // Step 3: Store result
        dp[n] = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);

        // Step 4: Return result
        return dp[n];
    }

    // Fibonacci using Tabulation
    int fibonacciTab(int n) {

        // Step 1: Create table
        int[] table = new int[n + 1];

        // Step 2: Base values
        table[0] = 0;

        if (n >= 1) {
            table[1] = 1;
        }

        // Step 3: Fill table
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        // Step 4: Return answer
        return table[n];
    }

    // Display DP Array
    void showDP() {

        // Step 1: Traverse DP array
        for (int value : dp) {

            // Ignore unused values
            if (value != -1) {
                System.out.print(value + " ");
            }
        }
    }
}