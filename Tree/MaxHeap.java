package Tree;

/*
--------------------------------------------------
Data Structure: Max Heap

Description:
A Max Heap is a Complete Binary Tree where:

Parent Node >= Child Nodes

Array Representation:
Parent Index = i
Left Child  = 2*i + 1
Right Child = 2*i + 2

Operations:
1. Insert
2. Delete Root
3. Heapify
4. Peek Maximum
5. Extract Maximum
6. Display Heap
7. Heap Sort

Time Complexity:
Insert      : O(log n)
Delete      : O(log n)
Peek        : O(1)
Heap Sort   : O(n log n)

Space Complexity:
O(n)
--------------------------------------------------
*/

public class MaxHeap {

    int[] heap; // Step 1: Array for heap

    int size; // Step 2: Current size

    int capacity; // Step 3: Maximum size

    // Constructor
    MaxHeap(int capacity) {

        // Step 1: Initialize capacity
        this.capacity = capacity;

        // Step 2: Create heap array
        heap = new int[capacity];

        // Step 3: Initial size = 0
        size = 0;
    }

    /*
    --------------------------------------------------
    1. Insert Element
    --------------------------------------------------
    */

    void insert(int data) {

        // Step 1: Check overflow
        if (size == capacity) {
            System.out.println("Heap Overflow");
            return;
        }

        // Step 2: Insert at last index
        heap[size] = data;

        // Step 3: Store current index
        int current = size;

        // Step 4: Increase size
        size++;

        // Step 5: Heapify upward
        while (current > 0) {

            // Parent index
            int parent = (current - 1) / 2;

            // Swap if child is greater
            if (heap[current] > heap[parent]) {

                int temp = heap[current];
                heap[current] = heap[parent];
                heap[parent] = temp;

                current = parent;
            }

            else {
                break;
            }
        }
    }

    /*
    --------------------------------------------------
    2. Delete Root Node
    --------------------------------------------------
    */

    void delete() {

        // Step 1: Check empty heap
        if (size == 0) {
            System.out.println("Heap is empty");
            return;
        }

        // Step 2: Replace root with last element
        heap[0] = heap[size - 1];

        // Step 3: Reduce heap size
        size--;

        // Step 4: Heapify downward
        heapify(0);
    }

    /*
    --------------------------------------------------
    3. Heapify Method
    --------------------------------------------------
    */

    void heapify(int index) {

        // Step 1: Assume largest = current
        int largest = index;

        // Step 2: Calculate child indexes
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;

        // Step 3: Compare left child
        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        // Step 4: Compare right child
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        // Step 5: Swap if needed
        if (largest != index) {

            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;

            // Step 6: Heapify recursively
            heapify(largest);
        }
    }

    /*
    --------------------------------------------------
    4. Peek Maximum Element
    --------------------------------------------------
    */

    int peek() {

        // Step 1: Check empty heap
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }

        // Step 2: Return root element
        return heap[0];
    }

    /*
    --------------------------------------------------
    5. Extract Maximum Element
    --------------------------------------------------
    */

    int extractMax() {

        // Step 1: Store maximum value
        int max = peek();

        // Step 2: Delete root
        delete();

        // Step 3: Return maximum
        return max;
    }

    /*
    --------------------------------------------------
    6. Display Heap
    --------------------------------------------------
    */

    void show() {

        // Step 1: Traverse heap
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    /*
    --------------------------------------------------
    7. Heap Sort
    --------------------------------------------------
    */

    void heapSort() {

        // Step 1: Store original size
        int originalSize = size;

        // Step 2: Repeatedly extract max
        while (size > 0) {

            // Swap root with last element
            int temp = heap[0];
            heap[0] = heap[size - 1];
            heap[size - 1] = temp;

            // Reduce heap size
            size--;

            // Heapify root
            heapify(0);
        }

        // Step 3: Print sorted array
        System.out.print("Heap Sort: ");

        for (int i = 0; i < originalSize; i++) {
            System.out.print(heap[i] + " ");
        }

        // Step 4: Restore original size
        size = originalSize;
    }
}