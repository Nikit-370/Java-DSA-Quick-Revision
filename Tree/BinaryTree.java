package Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
--------------------------------------------------
Data Structure: Tree Operations

Description:
This program performs common Binary Tree
operations.

Operations:
1. Inorder Traversal
2. Preorder Traversal
3. Postorder Traversal
4. Level Order Traversal
5. Count Total Nodes
6. Count Leaf Nodes
7. Height of Tree
8. Search Element
9. Find Minimum
10. Find Maximum

Tree Structure:
        10
       /  \
     20    30
    / \
   40  50

Time Complexity:
Traversal: O(n)

Space Complexity:
O(n)
--------------------------------------------------
*/

public class BinaryTree {

    Node root; // Step 1: Root node

    // Constructor
    BinaryTree() {
        root = null;
    }

    /*
    --------------------------------------------------
    1. Inorder Traversal

    Left -> Root -> Right
    --------------------------------------------------
    */

    void inorder(Node node) {

        // Step 1: Base condition
        if (node == null) {
            return;
        }

        // Step 2: Visit left subtree
        inorder(node.left);

        // Step 3: Print node
        System.out.print(node.data + " ");

        // Step 4: Visit right subtree
        inorder(node.right);
    }

    /*
    --------------------------------------------------
    2. Preorder Traversal

    Root -> Left -> Right
    --------------------------------------------------
    */

    void preorder(Node node) {

        // Step 1: Base condition
        if (node == null) {
            return;
        }

        // Step 2: Print node
        System.out.print(node.data + " ");

        // Step 3: Visit left subtree
        preorder(node.left);

        // Step 4: Visit right subtree
        preorder(node.right);
    }

    /*
    --------------------------------------------------
    3. Postorder Traversal

    Left -> Right -> Root
    --------------------------------------------------
    */

    void postorder(Node node) {

        // Step 1: Base condition
        if (node == null) {
            return;
        }

        // Step 2: Visit left subtree
        postorder(node.left);

        // Step 3: Visit right subtree
        postorder(node.right);

        // Step 4: Print node
        System.out.print(node.data + " ");
    }

    /*
    --------------------------------------------------
    4. Level Order Traversal

    Uses Queue (FIFO)
    --------------------------------------------------
    */

    void levelOrder() {

        // Step 1: Check empty tree
        if (root == null) {
            return;
        }

        // Step 2: Create queue
        Queue<Node> queue = new LinkedList<>();

        // Step 3: Add root
        queue.add(root);

        // Step 4: Traverse queue
        while (!queue.isEmpty()) {

            // Remove front node
            Node current = queue.remove();

            // Print node
            System.out.print(current.data + " ");

            // Add left child
            if (current.left != null) {
                queue.add(current.left);
            }

            // Add right child
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    /*
    --------------------------------------------------
    5. Count Total Nodes
    --------------------------------------------------
    */

    int countNodes(Node node) {

        // Step 1: Base condition
        if (node == null) {
            return 0;
        }

        // Step 2: Count left + right + current
        return 1 + countNodes(node.left)
                 + countNodes(node.right);
    }

    /*
    --------------------------------------------------
    6. Count Leaf Nodes
    --------------------------------------------------
    */

    int countLeafNodes(Node node) {

        // Step 1: Base condition
        if (node == null) {
            return 0;
        }

        // Step 2: Check leaf node
        if (node.left == null && node.right == null) {
            return 1;
        }

        // Step 3: Count leaf nodes
        return countLeafNodes(node.left)
                + countLeafNodes(node.right);
    }

    /*
    --------------------------------------------------
    7. Height of Tree
    --------------------------------------------------
    */

    int height(Node node) {

        // Step 1: Base condition
        if (node == null) {
            return 0;
        }

        // Step 2: Find left height
        int leftHeight = height(node.left);

        // Step 3: Find right height
        int rightHeight = height(node.right);

        // Step 4: Return maximum height + 1
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /*
    --------------------------------------------------
    8. Search Element
    --------------------------------------------------
    */

    boolean search(Node node, int key) {

        // Step 1: Base condition
        if (node == null) {
            return false;
        }

        // Step 2: Check current node
        if (node.data == key) {
            return true;
        }

        // Step 3: Search left or right subtree
        return search(node.left, key)
                || search(node.right, key);
    }

    /*
    --------------------------------------------------
    9. Find Minimum Node
    --------------------------------------------------
    */

    int findMin(Node node) {

        // Step 1: Base condition
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        // Step 2: Find minimum from subtrees
        int leftMin = findMin(node.left);
        int rightMin = findMin(node.right);

        // Step 3: Return minimum
        return Math.min(node.data,
                Math.min(leftMin, rightMin));
    }

    /*
    --------------------------------------------------
    10. Find Maximum Node
    --------------------------------------------------
    */

    int findMax(Node node) {

        // Step 1: Base condition
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        // Step 2: Find maximum from subtrees
        int leftMax = findMax(node.left);
        int rightMax = findMax(node.right);

        // Step 3: Return maximum
        return Math.max(node.data,
                Math.max(leftMax, rightMax));
    }
}