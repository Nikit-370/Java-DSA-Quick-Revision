package DP;

public class Driver {

    public static void main(String[] args) {

        // Step 1: Create object
        DP dp = new DP(10);

        int n = 7;

        // Step 2: Fibonacci using Memoization
        System.out.println("Memoization Result: " + dp.fibonacciMemo(n));

        // Step 3: Display stored DP values
        System.out.print("DP Array: ");
        dp.showDP();

        System.out.println();

        // Step 4: Fibonacci using Tabulation
        System.out.println("Tabulation Result: " + dp.fibonacciTab(n));
    }
}