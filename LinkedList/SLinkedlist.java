package LinkedList;

/*
--------------------------------------------------
Data Structure: Singly Linked List

Description:
A Linked List is a linear data structure where elements
(nodes) are stored in non-contiguous memory locations.

Each node contains:
- Data
- Reference (pointer) to the next node

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
O(n)  -> for storing nodes
--------------------------------------------------
*/

// Node class representing each element
class Node {

    int data;      // Step 1: store data
    Node next;     // Step 2: reference to next node
}

public class SLinkedlist {

    Node head;     // Step 3: head points to first node

    // Insert element at end
    void insert(int data) {

        // Step 1: Create new node
        Node node = new Node();
        node.data = data;
        node.next = null;

        // Step 2: If list is empty → make it head
        if (head == null) {
            head = node;
        } else {

            // Step 3: Traverse to last node
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }

            // Step 4: Attach new node at end
            n.next = node;
        }
    }

    // Insert element at beginning
    void insertAtStart(int data) {

        // Step 1: Create new node
        Node node = new Node();
        node.data = data;

        // Step 2: Point new node to current head
        node.next = head;

        // Step 3: Update head
        head = node;
    }

    // Insert element at specific index
    void insertAtIndex(int index, int data) {

        // Step 1: If index is 0 → insert at start
        if (index == 0) {
            insertAtStart(data);
            return;
        }

        // Step 2: Create new node
        Node node = new Node();
        node.data = data;

        // Step 3: Traverse to position before index
        Node n = head;
        for (int i = 0; i < index - 1; i++) {
            n = n.next;
        }

        // Step 4: Adjust links
        node.next = n.next;
        n.next = node;
    }

    // Delete element at given index
    void delete(int index) {

        // Step 1: If deleting first node
        if (index == 0) {
            head = head.next;
            return;
        }

        // Step 2: Traverse to node before index
        Node n = head;
        for (int i = 0; i < index - 1; i++) {
            n = n.next;
        }

        // Step 3: Remove node
        Node n1 = n.next;
        n.next = n1.next;
    }

    // Display linked list
    void show() {

        // Step 1: Start from head
        Node node = head;

        // Step 2: Traverse and print
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}