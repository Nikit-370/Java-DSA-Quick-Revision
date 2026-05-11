package Search;

/*
--------------------------------------------------
Algorithm: Binary Search (Iterative)

Description:
Binary Search is used to find an element in a sorted array.
It works by repeatedly dividing the search interval in half.
If the middle element is equal to the target, return it.
If the target is smaller, search the left half.
If the target is larger, search the right half.

Time Complexity:
Best Case: O(1)   -> when middle element is the target
Average Case: O(log n)
Worst Case: O(log n)

Space Complexity:
O(1)  -> iterative approach (no extra space used)
--------------------------------------------------
*/

class Binary {

    public static void main(String[] args) {

        // Step 1: Declare and initialize a sorted array
        int[] arr = { 2, 4, 6, 8, 10, 12 };

        // Step 2: Define the element to search
        int key = 12;

        // Step 3: Call binarySearch method and store result
        int result = binarySearch(arr, key);

        // Step 4: Check result and print output
        // If result is -1 → element not found
        // Otherwise print the position (1-based index)
        System.out.println(
            (result == -1)
            ? "Element not found"
            : "Element is at index: " + (result + 1)
        );
    }

    // Method to perform iterative binary search
    static int binarySearch(int arr[], int key) {

        // Step 1: Handle edge case (null or empty array)
        if (arr == null || arr.length == 0)
            return -1;

        // Step 2: Initialize starting and ending indices
        int start = 0;
        int end = arr.length - 1;

        // Step 3: Loop until search space is valid
        while (start <= end) {

            // Step 4: Calculate middle index (avoids overflow)
            int mid = start + (end - start) / 2;

            // Step 5: Check if middle element is the key
            if (arr[mid] == key)
                return mid;

            // Step 6: If key is smaller, search left half
            else if (arr[mid] > key)
                end = mid - 1;

            // Step 7: If key is larger, search right half
            else
                start = mid + 1;
        }

        // Step 8: Element not found
        return -1;
    }
}