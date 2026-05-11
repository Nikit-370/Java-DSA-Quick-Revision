package Search;

/*
--------------------------------------------------
Algorithm: Linear Search

Description:
Linear Search is the simplest searching algorithm.
It checks each element of the array one by one
until the target element is found or the array ends.

It works on both sorted and unsorted arrays.

Time Complexity:
Best Case: O(1)   -> when first element is the target
Average Case: O(n)
Worst Case: O(n)

Space Complexity:
O(1)  -> no extra space is used
--------------------------------------------------
*/

class Linear {

    public static void main(String[] args) {

        // Step 1: Declare and initialize the array
        int[] arr = { 2, 4, 6, 8, 10, 12 };

        // Step 2: Define the element to search
        int key = 6;

        // Step 3: Call linearSearch method
        int result = linearSearch(arr, key);

        // Step 4: Print result
        // If result is -1 → element not found
        // Otherwise print index (0-based)
        System.out.println(
            (result == -1)
            ? "Element not found"
            : "Element is at index: " + (result+1)
        );
    }

    // Method to perform linear search
    static int linearSearch(int[] arr, int key) {

        // Step 1: Handle edge case (null or empty array)
        if (arr == null || arr.length == 0)
            return -1;

        // Step 2: Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // Step 3: Check if current element matches key
            if (arr[i] == key) {
                return i; // element found → return index
            }
        }

        // Step 4: Element not found
        return -1;
    }
}