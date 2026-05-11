package Queue;

public class PQDriver {

    public static void main(String[] args) {

        // Step 1: Create priority queue
        PriorityQueue pq = new PriorityQueue(10);

        // Step 2: Insert elements
        pq.insert(10);
        pq.insert(30);
        pq.insert(20);
        pq.insert(50);

        // Step 3: Display heap
        pq.show(); // Heap structure

        System.out.println();

        // Step 4: Peek max
        System.out.println("Top: " + pq.peek());

        // Step 5: Remove max
        System.out.println("Removed: " + pq.remove());

        // Step 6: Display again
        pq.show();
    }
}