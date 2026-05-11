package Array;

/*
--------------------------------------------------
Data Structure: Array Operations

Description:
An array is a collection of elements stored in
contiguous memory locations.

This program demonstrates basic array operations:
- Traversal
- Insertion at end
- Insertion at index
- Deletion at index

Supports dynamic initialization using constructor.

Time Complexity:
Traversal: O(n)
Insertion: O(n)
Deletion: O(n)

Space Complexity:
O(n)
--------------------------------------------------
*/

public class Array {

    int[] arr; // Step 1: declare array
    int size = 0; // Step 2: track current elements
    int capacity; // Step 3: store max size

    // Constructor (default size = 5)
    Array() {
        capacity = 5;
        arr = new int[capacity];
    }

    // Constructor with custom size
    Array(int length) {
        capacity = length;
        arr = new int[capacity];
    }

    // Insert element at end
    void insert(int data) {

        // Step 1: Check overflow
        if (size == capacity) {
            System.out.println("Array is full");
            return;
        }

        // Step 2: Insert element
        arr[size] = data;

        // Step 3: Increase size
        size++;
    }

    // Insert at specific index
    void insertAtIndex(int index, int data) {

        // Step 1: Validate index
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }

        // Step 2: Check overflow
        if (size == capacity) {
            System.out.println("Array is full");
            return;
        }

        // Step 3: Shift elements to right
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        // Step 4: Insert element
        arr[index] = data;

        // Step 5: Increase size
        size++;
    }

    // Delete element at index
    void delete(int index) {

        // Step 1: Validate index
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }

        // Step 2: Shift elements to left
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Step 3: Decrease size
        size--;
    }

    // Display array
    void show() {

        // Step 1: Traverse and print
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}