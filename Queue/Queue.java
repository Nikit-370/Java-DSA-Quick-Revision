package Queue;

/*
--------------------------------------------------
Data Structure: Queue (Array Implementation)

Description:
A Queue is a linear data structure that follows
FIFO (First In First Out) principle.

Operations:
- enqueue() → insert element
- dequeue() → remove element
- peek()    → view front element
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

public class Queue {

    int[] queue; // Step 1: array to store elements
    int front = 0; // Step 2: front pointer
    int rear = -1; // Step 3: rear pointer
    int size = 0; // Step 4: current size
    int capacity; // Step 5: max size

    // Constructor (default size = 10)
    Queue() {
        capacity = 10;
        queue = new int[capacity];
    }

    // Constructor with custom size
    Queue(int size) {
        capacity = size;
        queue = new int[capacity];
    }

    // Enqueue element
    void enqueue(int data) {

        // Step 1: Check overflow
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }

        // Step 2: Move rear
        rear++;

        // Step 3: Insert element
        queue[rear] = data;

        // Step 4: Increase size
        size++;
    }

    // Dequeue element
    int dequeue() {

        // Step 1: Check underflow
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        // Step 2: Get front element
        int value = queue[front];

        // Step 3: Move front
        front++;

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

    // Check if queue is empty
    boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    boolean isFull() {
        return size == capacity;
    }

    // Get current size
    int size() {
        return size;
    }

    // Display queue
    void show() {

        // Step 1: Traverse from front to rear
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
    }
}