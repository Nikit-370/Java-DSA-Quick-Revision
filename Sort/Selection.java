package Sort;

/*
--------------------------------------------------
Algorithm: Selection Sort

Description:
Selection Sort repeatedly selects the smallest element
from the unsorted part of the array and places it
at the beginning.

Steps:
- Find the minimum element in the unsorted portion
- Swap it with the first unsorted element
- Move the boundary of sorted portion forward

Unlike Bubble Sort, it performs fewer swaps.

Time Complexity:
Best Case: O(n^2)
Average Case: O(n^2)
Worst Case: O(n^2)

Space Complexity:
O(1)  -> in-place sorting
--------------------------------------------------
*/

public class Selection {

    public static void main(String[] args) {

        // Step 1: Declare and initialize the array
        int[] arr = { 9, 4, 16, 72, 56, 19, 10 };

        // Step 2: Call selection sort
        selectionSort(arr, arr.length);

        // Step 3: Print sorted array
        for (int i : arr)
            System.out.print(i + " ");
    }

    // Method to perform selection sort
    static void selectionSort(int[] arr, int size) {

        // Step 1: Traverse through array
        for (int i = 0; i < size - 1; i++) {

            // Step 2: Assume current index is minimum
            int minIndex = i;

            // Step 3: Find actual minimum in remaining array
            for (int j = i + 1; j < size; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            // Step 4: Swap minimum element with current position
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}