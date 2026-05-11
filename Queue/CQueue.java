package Queue;

/*
--------------------------------------------------
Data Structure: Circular Queue (Array Implementation)

Description:
A Circular Queue is an improved version of a normal queue
where the last position connects back to the first.

It avoids memory wastage by reusing empty spaces.

Operations:
- enqueue()
- dequeue()
- peek()
- isEmpty()
- isFull()
- size()

Time Complexity:
Enqueue: O(1)
Dequeue: O(1)
Peek: O(1)

Space Complexity:
O(n)
--------------------------------------------------
*/

public class CQueue {

    int[] queue; // Step 1: array to store elements
    int front = 0; // Step 2: front pointer
    int rear = 0; // Step 3: rear pointer
    int size = 0; // Step 4: current size
    int capacity; // Step 5: max size

    // Constructor (default size = 10)
    CQueue() {
        capacity = 10;
        queue = new int[capacity];
    }

    // Constructor with custom size
    CQueue(int size) {
        capacity = size;
        queue = new int[capacity];
    }

    // Enqueue element
    void enqueue(int data) {

        // Step 1: Check if full
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }

        // Step 2: Insert element at rear
        queue[rear] = data;

        // Step 3: Move rear circularly
        rear = (rear + 1) % capacity;

        // Step 4: Increase size
        size++;
    }

    // Dequeue element
    int dequeue() {

        // Step 1: Check if empty
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        // Step 2: Get front element
        int value = queue[front];

        // Step 3: Move front circularly
        front = (front + 1) % capacity;

        // Step 4: Decrease size
        size--;

        return value;
    }

    // Peek front element
    int peek() {

        // Step 1: Check empty
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return queue[front];
    }

    // Check empty
    boolean isEmpty() {
        return size == 0;
    }

    // Check full
    boolean isFull() {
        return size == capacity;
    }

    // Get size
    int size() {
        return size;
    }

    // Display queue
    void show() {

        // Step 1: Traverse circularly
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
    }
}