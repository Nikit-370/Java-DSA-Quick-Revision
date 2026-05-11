package Matrix;

/*
--------------------------------------------------
Data Structure: Matrix

Description:
A Matrix is a 2D array consisting of rows
and columns.

Applications:
- Mathematical calculations
- Graph representation
- Image processing
- Game development

Operations:
- Insert Elements
- Display Matrix
- Addition
- Subtraction
- Multiplication
- Transpose

Time Complexity:
Traversal: O(rows * cols)
Addition: O(rows * cols)
Multiplication: O(r1 * c2 * c1)

Space Complexity:
O(rows * cols)
--------------------------------------------------
*/

public class Matrix {

    int[][] matrix; // Step 1: 2D array
    int rows; // Step 2: Number of rows
    int cols; // Step 3: Number of columns

    // Constructor
    Matrix(int rows, int cols) {

        // Step 4: Initialize variables
        this.rows = rows;
        this.cols = cols;

        // Step 5: Create matrix
        matrix = new int[rows][cols];
    }

    // Insert value into matrix
    void insert(int row, int col, int value) {

        // Step 1: Insert element
        matrix[row][col] = value;
    }

    // Display matrix
    void show() {

        // Step 1: Traverse rows
        for (int i = 0; i < rows; i++) {

            // Step 2: Traverse columns
            for (int j = 0; j < cols; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    // Matrix Addition
    Matrix add(Matrix other) {

        // Step 1: Create result matrix
        Matrix result = new Matrix(rows, cols);

        // Step 2: Add elements
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                result.matrix[i][j] =
                        matrix[i][j] + other.matrix[i][j];
            }
        }

        // Step 3: Return result
        return result;
    }

    // Matrix Subtraction
    Matrix subtract(Matrix other) {

        // Step 1: Create result matrix
        Matrix result = new Matrix(rows, cols);

        // Step 2: Subtract elements
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                result.matrix[i][j] =
                        matrix[i][j] - other.matrix[i][j];
            }
        }

        // Step 3: Return result
        return result;
    }

    // Matrix Multiplication
    Matrix multiply(Matrix other) {

        // Step 1: Create result matrix
        Matrix result = new Matrix(rows, other.cols);

        // Step 2: Multiply matrices
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < other.cols; j++) {

                for (int k = 0; k < cols; k++) {

                    result.matrix[i][j] +=
                            matrix[i][k] * other.matrix[k][j];
                }
            }
        }

        // Step 3: Return result
        return result;
    }

    // Transpose Matrix
    Matrix transpose() {

        // Step 1: Create transpose matrix
        Matrix result = new Matrix(cols, rows);

        // Step 2: Swap rows and columns
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                result.matrix[j][i] = matrix[i][j];
            }
        }

        // Step 3: Return transpose
        return result;
    }
}