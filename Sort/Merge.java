package Sort;

/*
--------------------------------------------------
Algorithm: Merge Sort

Description:
Merge Sort is a divide-and-conquer algorithm.

It works by:
- Dividing the array into two halves
- Recursively sorting each half
- Merging the sorted halves back together

The merge step combines two sorted arrays into one
sorted array.

It is stable and guarantees O(n log n) time.

Time Complexity:
Best Case: O(n log n)
Average Case: O(n log n)
Worst Case: O(n log n)

Space Complexity:
O(n)  -> extra space required for temporary arrays
--------------------------------------------------
*/

public class Merge {

    public static void main(String[] args) {

        // Step 1: Declare and initialize the array
        int[] arr = { 9, 4, 16, 72, 56, 19, 10 };

        // Step 2: Call mergeSort on full array
        mergeSort(arr, 0, arr.length - 1);

        // Step 3: Print sorted array
        for (int i : arr)
            System.out.print(i + " ");
    }

    // Method to perform merge sort
    static void mergeSort(int[] arr, int left, int right) {

        // Step 1: Check if more than one element
        if (left < right) {

            // Step 2: Find middle index
            int mid = left + (right - left) / 2;

            // Step 3: Recursively sort left half
            mergeSort(arr, left, mid);

            // Step 4: Recursively sort right half
            mergeSort(arr, mid + 1, right);

            // Step 5: Merge sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Method to merge two sorted subarrays
    static void merge(int[] arr, int left, int mid, int right) {

        // Step 1: Calculate sizes of subarrays
        int sizeLeftArr = mid - left + 1;
        int sizeRightArr = right - mid;

        // Step 2: Create temporary arrays
        int[] leftArr = new int[sizeLeftArr];
        int[] rightArr = new int[sizeRightArr];

        // Step 3: Copy data into left array
        for (int i = 0; i < sizeLeftArr; i++)
            leftArr[i] = arr[left + i];

        // Step 4: Copy data into right array
        for (int i = 0; i < sizeRightArr; i++)
            rightArr[i] = arr[mid + 1 + i];

        // Step 5: Initialize pointers
        int i = 0, j = 0;
        int k = left;

        // Step 6: Merge while both arrays have elements
        while (i < sizeLeftArr && j < sizeRightArr) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Step 7: Copy remaining elements of left array
        while (i < sizeLeftArr) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Step 8: Copy remaining elements of right array
        while (j < sizeRightArr) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}