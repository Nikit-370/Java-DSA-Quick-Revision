package LinkedList;

public class CDriver {

    public static void main(String[] args) {

        // Step 1: Create list
        CLinkedList list = new CLinkedList();

        // Step 2: Insert elements
        list.insert(5);
        list.insert(12);
        list.insert(10);

        // Step 3: Insert at start
        list.insertAtStart(20);
        list.insertAtStart(43);

        // Step 4: Delete element
        list.delete(2);

        // Step 5: Display list
        list.show();
    }
}