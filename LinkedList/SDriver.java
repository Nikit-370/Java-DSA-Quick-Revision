package LinkedList;

public class SDriver {

    public static void main(String[] args) {

        // Step 1: Create Linked List object
        SLinkedlist list = new SLinkedlist();

        // Step 2: Insert elements at end
        list.insert(5);
        list.insert(12);
        list.insert(10);

        // Step 3: Insert element at beginning
        list.insertAtStart(20);

        // Step 4: Insert elements at specific indices
        list.insertAtIndex(2, 14);
        list.insertAtIndex(4, 4);
        list.insertAtIndex(0, 43);

        // Step 5: Delete element at index
        list.delete(3);

        // Step 6: Display final linked list
        list.show();
    }
}