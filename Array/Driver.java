package Array;

public class Driver {

    public static void main(String[] args) {

        // Step 1: Create array object wiht size
        // default size = 5
        Array arr = new Array(10);

        // Step 2: Insert elements
        arr.insert(10);
        arr.insert(20);
        arr.insert(30);
        arr.insert(30);

        // Step 3: Insert at index
        arr.insertAtIndex(1, 15);

        // Step 4: Delete element
        arr.delete(2);

        // Step 5: Display array
        arr.show();
    }
}