package LinkedList;

/*
--------------------------------------------------
Data Structure: Circular Linked List

Description:
A Circular Linked List is a variation of a linked list
where the last node points back to the head instead of null.

There is no null pointer in the list.

Operations implemented:
- Insert at end
- Insert at beginning
- Delete at index
- Display list

Time Complexity:
Insertion (end): O(n)
Insertion (start): O(n)
Deletion: O(n)
Traversal: O(n)

Space Complexity:
O(n)
--------------------------------------------------
*/

// Node class
class CNode {

    int data; // Step 1: store data
    CNode next; // Step 2: next pointer
}

public class CLinkedList {

    CNode head; // Step 3: head node

    // Insert at end
    void insert(int data) {

        // Step 1: Create new node
        CNode node = new CNode();
        node.data = data;

        // Step 2: If list is empty
        if (head == null) {
            head = node;
            node.next = head; // point to itself
            return;
        }

        // Step 3: Traverse to last node
        CNode n = head;
        while (n.next != head) {
            n = n.next;
        }

        // Step 4: Insert new node
        n.next = node;
        node.next = head;
    }

    // Insert at beginning
    void insertAtStart(int data) {

        // Step 1: Create node
        CNode node = new CNode();
        node.data = data;

        // Step 2: If empty list
        if (head == null) {
            head = node;
            node.next = head;
            return;
        }

        // Step 3: Find last node
        CNode n = head;
        while (n.next != head) {
            n = n.next;
        }

        // Step 4: Insert at start
        node.next = head;
        n.next = node;
        head = node;
    }

    // Delete at index
    void delete(int index) {

        // Step 1: If empty list
        if (head == null)
            return;

        // Step 2: Delete head
        if (index == 0) {

            // If only one node
            if (head.next == head) {
                head = null;
                return;
            }

            // Find last node
            CNode n = head;
            while (n.next != head) {
                n = n.next;
            }

            // Update head and last node
            head = head.next;
            n.next = head;
            return;
        }

        // Step 3: Traverse to node before index
        CNode n = head;
        for (int i = 0; i < index - 1; i++) {
            n = n.next;
        }

        // Step 4: Delete node
        n.next = n.next.next;
    }

    // Display circular list
    void show() {

        // Step 1: If list is empty
        if (head == null)
            return;

        // Step 2: Start from head
        CNode node = head;

        // Step 3: Traverse circularly
        do {
            System.out.print(node.data + " ");
            node = node.next;
        } while (node != head);
    }
}