package Sort;

/*
--------------------------------------------------
Algorithm: Quick Sort

Description:
Quick Sort is a divide-and-conquer algorithm.

It works by:
- Selecting a pivot element
- Partitioning the array into two parts:
  elements smaller than pivot and greater than pivot
- Recursively sorting the left and right subarrays

In this implementation, the last element is chosen as pivot
(Lomuto partition scheme).

Time Complexity:
Best Case: O(n log n)
Average Case: O(n log n)
Worst Case: O(n^2)   -> when pivot is poorly chosen (e.g., sorted array)

Space Complexity:
O(log n) average -> due to recursion
O(n) worst case  -> deep recursion
--------------------------------------------------
*/

public class Quick {

    public static void main(String[] args) {

        // Step 1: Declare and initialize the array
        int[] arr = { 9, 4, 16, 72, 56, 19, 10 };

        // Step 2: Call quickSort on full array
        quickSort(arr, 0, arr.length - 1);

        // Step 3: Print sorted array
        for (int i : arr)
            System.out.print(i + " ");
    }

    // Method to perform quick sort
    static int[] quickSort(int[] arr, int low, int high) {

        // Step 1: Check if subarray has more than one element
        if (low < high) {

            // Step 2: Partition array and get pivot index
            int pi = partition(arr, low, high);

            // Step 3: Recursively sort left subarray
            quickSort(arr, low, pi - 1);

            // Step 4: Recursively sort right subarray
            quickSort(arr, pi + 1, high);
        }

        // Step 5: Return array (optional, for consistency)
        return arr;
    }

    // Method to partition array using Lomuto scheme
    static int partition(int[] arr, int low, int high) {

        // Step 1: Choose last element as pivot
        int pivot = arr[high];

        // Step 2: Initialize pointer for smaller elements
        int i = low - 1;

        // Step 3: Traverse array from low to high-1
        for (int j = low; j < high; j++) {

            // Step 4: If current element is smaller than pivot
            if (arr[j] < pivot) {

                // Move boundary of smaller elements
                i++;

                // Step 5: Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Step 6: Place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Step 7: Return pivot index
        return i + 1;
    }
}