package Stack;

public class Driver {

    public static void main(String[] args) {

        // Step 1: Create stack
        Stack stack = new Stack(5);

        // Step 2: Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Step 3: Display stack
        stack.show(); // Output: 30 20 10

        System.out.println();

        // Step 4: Peek top element
        System.out.println("Top element: " + stack.peek());

        // Step 5: Pop element
        System.out.println("Popped: " + stack.pop());

        // Step 6: Check if Empty
        System.out.println("Empty: " + stack.isEmpty());

        // Step 7: Check if Full
        System.out.println("Full: " + stack.isFull());

        // Step 8: Printing Size of stack
        System.out.println("Size of Stack: " + stack.size());

        // Step 9: Display after pop
        stack.show(); // Output: 20 10
    }
}