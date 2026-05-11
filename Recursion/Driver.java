package Recursion;

public class Driver {

    public static void main(String[] args) {

        // Step 1: Create object
        Recursion recursion = new Recursion();

        // Step 2: Factorial
        System.out.println("Factorial of 5: "
                + recursion.factorial(5));

        // Step 3: Fibonacci
        System.out.println("Fibonacci of 7: "
                + recursion.fibonacci(7));

        // Step 4: Print Ascending
        System.out.print("Ascending Order: ");
        recursion.printAscending(5);

        System.out.println();

        // Step 5: Print Descending
        System.out.print("Descending Order: ");
        recursion.printDescending(5);

        System.out.println();

        // Step 6: Sum of natural numbers
        System.out.println("Sum of 5 numbers: "
                + recursion.sum(5));
    }
}