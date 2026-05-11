package Matrix;

public class Driver {

    public static void main(String[] args) {

        // Step 1: Create first matrix
        Matrix m1 = new Matrix(2, 2);

        m1.insert(0, 0, 1);
        m1.insert(0, 1, 2);
        m1.insert(1, 0, 3);
        m1.insert(1, 1, 4);

        // Step 2: Create second matrix
        Matrix m2 = new Matrix(2, 2);

        m2.insert(0, 0, 5);
        m2.insert(0, 1, 6);
        m2.insert(1, 0, 7);
        m2.insert(1, 1, 8);

        // Step 3: Display matrices
        System.out.println("Matrix 1:");
        m1.show();

        System.out.println();

        System.out.println("Matrix 2:");
        m2.show();

        System.out.println();

        // Step 4: Matrix Addition
        System.out.println("Addition:");
        Matrix add = m1.add(m2);
        add.show();

        System.out.println();

        // Step 5: Matrix Subtraction
        System.out.println("Subtraction:");
        Matrix sub = m1.subtract(m2);
        sub.show();

        System.out.println();

        // Step 6: Matrix Multiplication
        System.out.println("Multiplication:");
        Matrix mul = m1.multiply(m2);
        mul.show();

        System.out.println();

        // Step 7: Matrix Transpose
        System.out.println("Transpose of Matrix 1:");
        Matrix transpose = m1.transpose();
        transpose.show();
    }
}