package Queue;

/*
--------------------------------------------------
Data Structure: Priority Queue (Max Heap)

Description:
A Priority Queue is a special queue where elements
are removed based on priority, not order.

Higher value → higher priority (Max Heap)

Operations:
- insert()
- remove()  → removes highest priority element
- peek()
- isEmpty()
- size()

Time Complexity:
Insert: O(log n)
Remove: O(log n)
Peek: O(1)

Space Complexity:
O(n)
--------------------------------------------------
*/

public class PriorityQueue {

    int[] heap;      // Step 1: array to store heap
    int size = 0;    // Step 2: current size
    int capacity;    // Step 3: max size

    // Constructor (default size = 10)
    PriorityQueue() {
        capacity = 10;
        heap = new int[capacity];
    }

    // Constructor with custom size
    PriorityQueue(int size) {
        capacity = size;
        heap = new int[capacity];
    }

    // Insert element
    void insert(int data) {

        // Step 1: Check overflow
        if (size == capacity) {
            System.out.println("Queue Overflow");
            return;
        }

        // Step 2: Insert at end
        heap[size] = data;

        // Step 3: Heapify up
        int i = size;
        while (i > 0 && heap[i] > heap[(i - 1) / 2]) {

            // Swap with parent
            int temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;

            i = (i - 1) / 2;
        }

        size++;
    }

    // Remove highest priority (root)
    int remove() {

        // Step 1: Check empty
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int root = heap[0];

        // Step 2: Replace root with last element
        heap[0] = heap[size - 1];
        size--;

        // Step 3: Heapify down
        int i = 0;

        while (true) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < size && heap[left] > heap[largest])
                largest = left;

            if (right < size && heap[right] > heap[largest])
                largest = right;

            if (largest != i) {

                int temp = heap[i];
                heap[i] = heap[largest];
                heap[largest] = temp;

                i = largest;
            } else {
                break;
            }
        }

        return root;
    }

    // Peek highest priority
    int peek() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return heap[0];
    }

    // Check empty
    boolean isEmpty() {
        return size == 0;
    }

    // Get size
    int size() {
        return size;
    }

    // Display heap
    void show() {

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}