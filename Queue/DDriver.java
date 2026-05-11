package Queue;

public class DDriver {

    public static void main(String[] args) {

        // Step 1: Create deque
        DQueue dq = new DQueue(5);

        // Step 2: Insert elements
        dq.insertRear(10);
        dq.insertRear(20);
        dq.insertFront(5);
        dq.insertFront(2);

        // Step 3: Display
        dq.show(); // Output: 2 5 10 20

        System.out.println();

        // Step 4: Delete operations
        dq.deleteFront();
        dq.deleteRear();

        // Step 5: Display again
        dq.show(); // Output: 5 10

        System.out.println("\nFront: " + dq.peekFront());
        System.out.println("Rear: " + dq.peekRear());
    }
}