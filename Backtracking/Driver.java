package Backtracking;

public class Driver {

    public static void main(String[] args) {

        // Step 1: Create object
        Backtracking backtracking = new Backtracking();

        // Step 2: Print numbers
        System.out.print("Backtracking Numbers: ");
        backtracking.printNumbers(5);

        System.out.println();

        // Step 3: Generate binary sequences
        System.out.println("Binary Sequences:");
        backtracking.binarySequence(3);
    }
}