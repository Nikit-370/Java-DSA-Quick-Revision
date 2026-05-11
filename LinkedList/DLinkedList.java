package LinkedList;

/*
--------------------------------------------------
Data Structure: Doubly Linked List

Description:
A Doubly Linked List is a linear data structure where
each node contains:
- Data
- Reference to next node
- Reference to previous node

It allows traversal in both directions.

Operations implemented:
- Insert at end
- Insert at beginning
- Insert at index
- Delete at index
- Display list

Time Complexity:
Insertion (end): O(n)
Insertion (start): O(1)
Insertion (index): O(n)
Deletion: O(n)
Traversal: O(n)

Space Complexity:
O(n)  -> extra space for prev pointers
--------------------------------------------------
*/

// Node class
class DNode {

    int data;        // Step 1: store data
    DNode next;      // Step 2: next pointer
    DNode prev;      // Step 3: previous pointer
}

public class DLinkedList {

    DNode head;      // Step 4: head node

    // Insert at end
    void insert(int data) {

        // Step 1: Create new node
        DNode node = new DNode();
        node.data = data;
        node.next = null;
        node.prev = null;

        // Step 2: If list is empty
        if (head == null) {
            head = node;
            return;
        }

        // Step 3: Traverse to last node
        DNode n = head;
        while (n.next != null) {
            n = n.next;
        }

        // Step 4: Link nodes
        n.next = node;
        node.prev = n;
    }

    // Insert at beginning
    void insertAtStart(int data) {

        // Step 1: Create new node
        DNode node = new DNode();
        node.data = data;

        // Step 2: Link with current head
        node.next = head;
        node.prev = null;

        if (head != null)
            head.prev = node;

        // Step 3: Update head
        head = node;
    }

    // Insert at index
    void insertAtIndex(int index, int data) {

        // Step 1: If index is 0
        if (index == 0) {
            insertAtStart(data);
            return;
        }

        // Step 2: Create node
        DNode node = new DNode();
        node.data = data;

        // Step 3: Traverse to position
        DNode n = head;
        for (int i = 0; i < index - 1; i++) {
            n = n.next;
        }

        // Step 4: Adjust links
        node.next = n.next;
        node.prev = n;

        if (n.next != null)
            n.next.prev = node;

        n.next = node;
    }

    // Delete at index
    void delete(int index) {

        // Step 1: If deleting head
        if (index == 0) {
            head = head.next;

            if (head != null)
                head.prev = null;

            return;
        }

        // Step 2: Traverse to node
        DNode n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }

        // Step 3: Adjust links
        if (n.next != null)
            n.next.prev = n.prev;

        if (n.prev != null)
            n.prev.next = n.next;
    }

    // Display list
    void show() {

        // Step 1: Start from head
        DNode node = head;

        // Step 2: Traverse forward
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}