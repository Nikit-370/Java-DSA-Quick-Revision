package Sort;

/*
--------------------------------------------------
Algorithm: Bubble Sort (Optimized)

Description:
Bubble Sort compares adjacent elements and swaps them
if they are in the wrong order.

In this optimized version, a boolean flag is used to
check if any swap occurred during a pass.

- If no swaps happen → array is already sorted
- So we stop early instead of unnecessary iterations

Time Complexity:
Best Case: O(n)        -> when array is already sorted
Average Case: O(n^2)
Worst Case: O(n^2)

Space Complexity:
O(1)  -> in-place sorting
--------------------------------------------------
*/

public class Bubble {

    public static void main(String[] args) {

        // Step 1: Declare and initialize the array
        int[] arr = { 90, 4, 16, 72, 56, 19, 10 };

        // Step 2: Call optimized bubble sort
        bubbleSort(arr, arr.length);

        // Step 3: Print sorted array
        for (int i : arr)
            System.out.print(i + " ");
    }

    // Method to perform optimized bubble sort
    static void bubbleSort(int[] arr, int size) {

        // Step 1: Outer loop for passes
        for (int i = 0; i < size - 1; i++) {

            // Step 2: Initialize swap flag
            boolean swapped = false;

            // Step 3: Inner loop for comparisons
            for (int j = 0; j < size - 1 - i; j++) {

                // Step 4: Compare adjacent elements
                if (arr[j] > arr[j + 1]) {

                    // Step 5: Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Step 6: Mark that a swap occurred
                    swapped = true;
                }
            }

            // Step 7: If no swaps → array is already sorted
            if (!swapped)
                break;
        }
    }
}