package Queue;

/*
--------------------------------------------------
Data Structure: Deque (Double Ended Queue)

Description:
A Deque (Double Ended Queue) allows insertion and
deletion from both ends:
- Front
- Rear

It is implemented using a circular array.

Operations:
- insertFront()
- insertRear()
- deleteFront()
- deleteRear()
- peekFront()
- peekRear()
- isEmpty()
- isFull()
- size()

Time Complexity:
All operations: O(1)

Space Complexity:
O(n)
--------------------------------------------------
*/

public class DQueue {

    int[] deque; // Step 1: array
    int front = -1; // Step 2: front pointer
    int rear = -1; // Step 3: rear pointer
    int size = 0; // Step 4: current size
    int capacity; // Step 5: max size

    // Constructor (default size = 10)
    DQueue() {
        capacity = 10;
        deque = new int[capacity];
    }

    // Constructor with custom size
    DQueue(int size) {
        capacity = size;
        deque = new int[capacity];
    }

    // Insert at front
    void insertFront(int data) {

        // Step 1: Check full
        if (isFull()) {
            System.out.println("Deque Overflow");
            return;
        }

        // Step 2: If empty
        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        // Step 3: Insert element
        deque[front] = data;
        size++;
    }

    // Insert at rear
    void insertRear(int data) {

        // Step 1: Check full
        if (isFull()) {
            System.out.println("Deque Overflow");
            return;
        }

        // Step 2: If empty
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        // Step 3: Insert element
        deque[rear] = data;
        size++;
    }

    // Delete from front
    int deleteFront() {

        // Step 1: Check empty
        if (isEmpty()) {
            System.out.println("Deque Underflow");
            return -1;
        }

        int value = deque[front];

        // Step 2: If single element
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        size--;
        return value;
    }

    // Delete from rear
    int deleteRear() {

        // Step 1: Check empty
        if (isEmpty()) {
            System.out.println("Deque Underflow");
            return -1;
        }

        int value = deque[rear];

        // Step 2: If single element
        if (front == rear) {
            front = rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }

        size--;
        return value;
    }

    // Peek front
    int peekFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return deque[front];
    }

    // Peek rear
    int peekRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return deque[rear];
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

    // Display deque
    void show() {

        for (int i = 0; i < size; i++) {
            System.out.print(deque[(front + i) % capacity] + " ");
        }
    }
}