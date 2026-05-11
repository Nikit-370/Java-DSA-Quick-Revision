package Queue;

public class CDriver {

    public static void main(String[] args) {

        // Step 1: Create circular queue
        CQueue q = new CQueue(5);

        // Step 2: Enqueue elements
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        // Step 3: Display queue
        q.show(); // Output: 10 20 30 40 50

        System.out.println();

        // Step 4: Dequeue elements
        q.dequeue();
        q.dequeue();

        // Step 5: Add more elements (reuse space)
        q.enqueue(60);
        q.enqueue(70);

        // Step 6: Display again
        q.show(); // Output: 30 40 50 60 70

        System.out.println("\nFront: " + q.peek());
        System.out.println("Size: " + q.size());
    }
}