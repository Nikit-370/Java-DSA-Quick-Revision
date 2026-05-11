package Array;

/*
--------------------------------------------------
Data Structure: 2D Array (Multi-Dimensional Array)

Description:
A 2D array is a collection of elements arranged
in rows and columns (matrix form).

This program demonstrates:
- Traversal (row-wise)
- Insertion at specific position
- Update element
- Display matrix

Time Complexity:
Traversal: O(n * m)
Insertion/Update: O(1)

Space Complexity:
O(n * m)
--------------------------------------------------
*/

public class Array2D {

    int[][] arr; // Step 1: declare 2D array
    int rows, cols; // Step 2: store dimensions

    // Default constructor (3x3)
    Array2D() {
        rows = 3;
        cols = 3;
        arr = new int[rows][cols];
    }

    // Constructor with custom size
    Array2D(int r, int c) {
        rows = r;
        cols = c;
        arr = new int[rows][cols];
    }

    // Insert element at position
    void insert(int row, int col, int data) {

        // Step 1: Validate indices
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            System.out.println("Invalid index");
            return;
        }

        // Step 2: Insert element
        arr[row][col] = data;
    }

    // Update element
    void update(int row, int col, int data) {

        // Step 1: Validate indices
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            System.out.println("Invalid index");
            return;
        }

        // Step 2: Update value
        arr[row][col] = data;
    }

    // Display array (row-wise)
    void show() {

        // Step 1: Traverse rows
        for (int i = 0; i < rows; i++) {

            // Step 2: Traverse columns
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + " ");
            }

            // Step 3: New line after each row
            System.out.println();
        }
    }
}