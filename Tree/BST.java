package Tree;

/*
--------------------------------------------------
Data Structure: Binary Search Tree (BST)

Description:
A Binary Search Tree is a Binary Tree
where:

Left Subtree  < Root
Right Subtree > Root

Operations:
1. Insert Node
2. Search Node
3. Delete Node
4. Inorder Traversal
5. Preorder Traversal
6. Postorder Traversal
7. Find Minimum
8. Find Maximum
9. Count Nodes
10. Height of Tree

Time Complexity:
Average Case:
Insert/Search/Delete -> O(log n)

Worst Case:
O(n)

Space Complexity:
O(n)
--------------------------------------------------
*/

public class BST {

    Node root; // Step 1: Root node

    // Constructor
    BST() {
        root = null;
    }

    /*
    --------------------------------------------------
    1. Insert Node
    --------------------------------------------------
    */

    Node insert(Node node, int data) {

        // Step 1: Create new node if empty
        if (node == null) {
            return new Node(data);
        }

        // Step 2: Insert in left subtree
        if (data < node.data) {
            node.left = insert(node.left, data);
        }

        // Step 3: Insert in right subtree
        else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        // Step 4: Return node
        return node;
    }

    /*
    --------------------------------------------------
    2. Search Node
    --------------------------------------------------
    */

    boolean search(Node node, int key) {

        // Step 1: Base condition
        if (node == null) {
            return false;
        }

        // Step 2: Element found
        if (node.data == key) {
            return true;
        }

        // Step 3: Search left subtree
        if (key < node.data) {
            return search(node.left, key);
        }

        // Step 4: Search right subtree
        return search(node.right, key);
    }

    /*
    --------------------------------------------------
    3. Delete Node
    --------------------------------------------------
    */

    Node delete(Node node, int key) {

        // Step 1: Base condition
        if (node == null) {
            return null;
        }

        // Step 2: Traverse left subtree
        if (key < node.data) {
            node.left = delete(node.left, key);
        }

        // Step 3: Traverse right subtree
        else if (key > node.data) {
            node.right = delete(node.right, key);
        }

        // Step 4: Node found
        else {

            // Case 1: No left child
            if (node.left == null) {
                return node.right;
            }

            // Case 2: No right child
            else if (node.right == null) {
                return node.left;
            }

            // Case 3: Two children
            else {

                // Find inorder successor
                int minValue = findMin(node.right);

                // Replace node data
                node.data = minValue;

                // Delete inorder successor
                node.right = delete(node.right, minValue);
            }
        }

        return node;
    }

    /*
    --------------------------------------------------
    4. Inorder Traversal

    Left -> Root -> Right
    --------------------------------------------------
    */

    void inorder(Node node) {

        if (node == null) {
            return;
        }

        inorder(node.left);

        System.out.print(node.data + " ");

        inorder(node.right);
    }

    /*
    --------------------------------------------------
    5. Preorder Traversal

    Root -> Left -> Right
    --------------------------------------------------
    */

    void preorder(Node node) {

        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");

        preorder(node.left);

        preorder(node.right);
    }

    /*
    --------------------------------------------------
    6. Postorder Traversal

    Left -> Right -> Root
    --------------------------------------------------
    */

    void postorder(Node node) {

        if (node == null) {
            return;
        }

        postorder(node.left);

        postorder(node.right);

        System.out.print(node.data + " ");
    }

    /*
    --------------------------------------------------
    7. Find Minimum
    --------------------------------------------------
    */

    int findMin(Node node) {

        // Step 1: Traverse leftmost node
        while (node.left != null) {
            node = node.left;
        }

        // Step 2: Return minimum value
        return node.data;
    }

    /*
    --------------------------------------------------
    8. Find Maximum
    --------------------------------------------------
    */

    int findMax(Node node) {

        // Step 1: Traverse rightmost node
        while (node.right != null) {
            node = node.right;
        }

        // Step 2: Return maximum value
        return node.data;
    }

    /*
    --------------------------------------------------
    9. Count Total Nodes
    --------------------------------------------------
    */

    int countNodes(Node node) {

        // Step 1: Base condition
        if (node == null) {
            return 0;
        }

        // Step 2: Count left + right + root
        return 1 + countNodes(node.left)
                 + countNodes(node.right);
    }

    /*
    --------------------------------------------------
    10. Height of Tree
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
}