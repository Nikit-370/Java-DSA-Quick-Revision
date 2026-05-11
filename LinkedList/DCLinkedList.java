package LinkedList;

/*
--------------------------------------------------
Data Structure: Doubly Circular Linked List

Description:
A Doubly Circular Linked List is a combination of:
- Doubly Linked List (next + prev pointers)
- Circular Linked List (last node connects to head)

Features:
- Each node has next and prev
- Last node's next → head
- Head's prev → last node
- No null pointers

Operations implemented:
- Insert at end
- Insert at beginning
- Delete at index
- Display list

Time Complexity:
Insertion: O(n)
Deletion: O(n)
Traversal: O(n)

Space Complexity:
O(n)
--------------------------------------------------
*/

// Node class
class DCNode {

    int data; // Step 1: store data
    DCNode next; // Step 2: next pointer
    DCNode prev; // Step 3: previous pointer
}

public class DCLinkedList {

    DCNode head; // Step 4: head node

    // Insert at end
    void insert(int data) {

        // Step 1: Create new node
        DCNode node = new DCNode();
        node.data = data;

        // Step 2: If list is empty
        if (head == null) {
            head = node;
            node.next = node;
            node.prev = node;
            return;
        }

        // Step 3: Get last node
        DCNode last = head.prev;

        // Step 4: Adjust links
        last.next = node;
        node.prev = last;

        node.next = head;
        head.prev = node;
    }

    // Insert at beginning
    void insertAtStart(int data) {

        // Step 1: Create node
        DCNode node = new DCNode();
        node.data = data;

        // Step 2: If empty list
        if (head == null) {
            head = node;
            node.next = node;
            node.prev = node;
            return;
        }

        // Step 3: Get last node
        DCNode last = head.prev;

        // Step 4: Adjust links
        node.next = head;
        node.prev = last;

        last.next = node;
        head.prev = node;

        // Step 5: Update head
        head = node;
    }

    // Delete at index
    void delete(int index) {

        // Step 1: If empty
        if (head == null)
            return;

        // Step 2: If deleting head
        if (index == 0) {

            // Only one node
            if (head.next == head) {
                head = null;
                return;
            }

            DCNode last = head.prev;

            head = head.next;

            head.prev = last;
            last.next = head;

            return;
        }

        // Step 3: Traverse to node
        DCNode n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }

        // Step 4: Adjust links
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    // Display list
    void show() {

        // Step 1: If empty
        if (head == null)
            return;

        // Step 2: Traverse circularly
        DCNode node = head;
        do {
            System.out.print(node.data + " ");
            node = node.next;
        } while (node != head);
    }
}