package Sort;

/*
--------------------------------------------------
Algorithm: Insertion Sort

Description:
Insertion Sort builds the sorted array one element at a time.

It takes each element and inserts it into its correct
position in the already sorted part of the array.

Similar to how we sort playing cards in hand.

Steps:
- Pick an element (key)
- Compare it with previous elements
- Shift larger elements to the right
- Insert the key at the correct position

Time Complexity:
Best Case: O(n)        -> when array is already sorted
Average Case: O(n^2)
Worst Case: O(n^2)

Space Complexity:
O(1)  -> in-place sorting
--------------------------------------------------
*/

public class Insertion {

    public static void main(String[] args) {

        // Step 1: Declare and initialize the array
        int[] arr = { 9, 4, 16, 72, 56, 19, 10 };

        // Step 2: Call insertion sort
        insertionSort(arr, arr.length);

        // Step 3: Print sorted array
        for (int i : arr)
            System.out.print(i + " ");
    }

    // Method to perform insertion sort
    static void insertionSort(int[] arr, int size) {

        // Step 1: Start from second element
        for (int i = 1; i < size; i++) {

            // Step 2: Store current element as key
            int key = arr[i];

            // Step 3: Compare with previous elements
            int j = i - 1;

            // Step 4: Shift elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Step 5: Insert key at correct position
            arr[j + 1] = key;
        }
    }
}