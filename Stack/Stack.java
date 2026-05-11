package Stack;

/*
--------------------------------------------------
Data Structure: Stack (Array Implementation)

Description:
A Stack is a linear data structure that follows
LIFO (Last In First Out) principle.

Operations:
- push()   → insert element
- pop()    → remove element
- peek()   → view top element
- isEmpty()
- isFull()

Time Complexity:
Push: O(1)
Pop: O(1)
Peek: O(1)

Space Complexity:
O(n)
--------------------------------------------------
*/

public class Stack {

    int[] stack; // Step 1: array to store elements
    int top = -1; // Step 2: pointer to top element
    int capacity; // Step 3: maximum size

    // Default constructor (size = 10)
    Stack() {
        capacity = 10;
        stack = new int[capacity];
    }

    // Constructor with custom size
    Stack(int size) {
        capacity = size;
        stack = new int[capacity];
    }

    // Push element onto stack
    void push(int data) {

        // Step 1: Check overflow
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        // Step 2: Increment top
        top++;

        // Step 3: Insert element
        stack[top] = data;
    }

    // Pop element from stack
    int pop() {

        // Step 1: Check underflow
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }

        // Step 2: Get top element
        int value = stack[top];

        // Step 3: Decrement top
        top--;

        // Step 4: Return value
        return value;
    }

    // Peek top element
    int peek() {

        // Step 1: Check empty
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        // Step 2: Return top element
        return stack[top];
    }

    // Check if stack is empty
    boolean isEmpty() {
        return top == -1;
    }

    // Check if stack is full
    boolean isFull() {
        return top == capacity - 1;
    }

    // Get current size of stack
    int size() {
        return top + 1;
    }

    // Display stack
    void show() {

        // Using For each to print Non-Zeros values
        // for (int i : stack)
        // if (i != 0)
        // System.out.print(i + " ");

        // Step 1: Traverse from top to bottom
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
    }
}