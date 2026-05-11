package DP;

public class Driver1D {

    public static void main(String[] args) {

        // Step 1: Create object
        DP1D dp = new DP1D(10);

        // Step 2: Calculate Fibonacci
        System.out.println("Result: " + dp.fibonacci(7));

        // Step 3: Display DP array
        System.out.print("DP Array: ");
        dp.show();
    }
}