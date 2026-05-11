package DP;

public class Driver2D {

    public static void main(String[] args) {

        // Step 1: Create object
        DP2D dp = new DP2D(3, 3);

        // Step 2: Count paths
        System.out.println("Total Paths: " + dp.countPaths(3, 3));

        // Step 3: Display DP table
        System.out.println("DP Table:");

        dp.show();
    }
}