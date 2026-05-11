package Tree;

/*
--------------------------------------------------
Data Structure: Tree Node

Description:
A Node is the basic building block of a Tree.

Each node contains:
1. Data
2. Reference to left child
3. Reference to right child

Tree Structure:
        10
       /  \
     20    30

Time Complexity:
Node Creation: O(1)

Space Complexity:
O(1)
--------------------------------------------------
*/

public class Node {

    int data;       // Step 1: Store node data

    Node left;      // Step 2: Reference to left child

    Node right;     // Step 3: Reference to right child

    // Constructor
    Node(int data) {

        // Step 1: Initialize data
        this.data = data;

        // Step 2: Initially children are null
        left = null;
        right = null;
    }
}