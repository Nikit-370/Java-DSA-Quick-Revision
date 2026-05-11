package Array;

public class Driver2D {

    public static void main(String[] args) {

        // Step 1: Create 2D array (3x3)
        Array2D arr = new Array2D(3, 3);

        // Step 2: Insert values
        arr.insert(0, 0, 10);
        arr.insert(0, 1, 20);
        arr.insert(0, 2, 30);

        arr.insert(1, 0, 40);
        arr.insert(1, 1, 50);
        arr.insert(1, 2, 60);

        arr.insert(2, 0, 70);
        arr.insert(2, 1, 80);
        arr.insert(2, 2, 90);

        // Step 3: Update a value
        arr.update(1, 1, 99);

        // Step 4: Display matrix
        arr.show();
    }
}