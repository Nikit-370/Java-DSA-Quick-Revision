package Queue;

public class Driver {

    public static void main(String[] args) {

        // Step 1: Create queue
        Queue q = new Queue(5);

        // Step 2: Enqueue elements
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        // Step 3: Display queue
        q.show();   // Output: 10 20 30

        System.out.println();

        // Step 4: Peek
        System.out.println("Front: " + q.peek());

        // Step 5: Dequeue
        System.out.println("Removed: " + q.dequeue());

        // Step 6: Display again
        q.show();   // Output: 20 30

        System.out.println("\nSize: " + q.size());
    }
}