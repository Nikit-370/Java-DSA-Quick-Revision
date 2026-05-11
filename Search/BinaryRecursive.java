package Search;

/*
--------------------------------------------------
Algorithm: Binary Search (Recursive)

Description:
Binary Search recursively finds an element in a sorted array
by dividing the search space into halves.

At each step:
- Find the middle element
- If it matches the key → return index
- If key is smaller → search left half
- If key is larger → search right half

The process continues until the element is found
or the search space becomes invalid.

Time Complexity:
Best Case: O(1)   -> when middle element is the target
Average Case: O(log n)
Worst Case: O(log n)

Space Complexity:
O(log n)  -> due to recursive call stack
--------------------------------------------------
*/

class BinaryRecursive {

    public static void main(String[] args) {

        // Step 1: Declare and initialize a sorted array
        int[] arr = { 2, 4, 6, 8, 10, 12 };

        // Step 2: Define the element to search
        int key = 12;

        // Step 3: Call recursive binary search
        int result = binarySearch(arr, key, 0, arr.length - 1);

        // Step 4: Print result
        // If result is -1 → element not found
        // Otherwise print 1-based index
        System.out.println(
            (result == -1)
            ? "Element not found"
            : "Element is at index: " + (result + 1)
        );
    }

    // Recursive method for binary search
    static int binarySearch(int[] arr, int key, int start, int end) {

        // Step 1: Base case
        // If array is null/empty OR search space is invalid
        if (arr == null || arr.length == 0 || start > end)
            return -1;

        // Step 2: Find middle index safely
        int mid = start + (end - start) / 2;

        // Step 3: Check if middle element is the key
        if (arr[mid] == key)
            return mid;

        // Step 4: If key is smaller, search left half
        else if (arr[mid] > key)
            return binarySearch(arr, key, start, mid - 1);

        // Step 5: If key is larger, search right half
        else
            return binarySearch(arr, key, mid + 1, end);
    }
}