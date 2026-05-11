package Recursion;

/*
--------------------------------------------------
Concept: Recursion

Description:
Recursion is a programming technique where
a function calls itself repeatedly until a
base condition is reached.

Important Terms:
- Base Condition
- Recursive Call
- Call Stack

Applications:
- Factorial
- Fibonacci
- Tree Traversal
- Backtracking

Time Complexity:
Depends on recursive calls

Space Complexity:
Depends on call stack
--------------------------------------------------
*/

public class Recursion {

    // Factorial using recursion
    int factorial(int n) {

        // Step 1: Base condition
        if (n == 0 || n == 1) {
            return 1;
        }

        // Step 2: Recursive call
        return n * factorial(n - 1);
    }

    // Fibonacci using recursion
    int fibonacci(int n) {

        // Step 1: Base condition
        if (n <= 1) {
            return n;
        }

        // Step 2: Recursive calls
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Print numbers from 1 to n
    void printAscending(int n) {

        // Step 1: Base condition
        if (n == 0) {
            return;
        }

        // Step 2: Recursive call
        printAscending(n - 1);

        // Step 3: Print number
        System.out.print(n + " ");
    }

    // Print numbers from n to 1
    void printDescending(int n) {

        // Step 1: Base condition
        if (n == 0) {
            return;
        }

        // Step 2: Print number
        System.out.print(n + " ");

        // Step 3: Recursive call
        printDescending(n - 1);
    }

    // Sum of first n natural numbers
    int sum(int n) {

        // Step 1: Base condition
        if (n == 1) {
            return 1;
        }

        // Step 2: Recursive call
        return n + sum(n - 1);
    }
}