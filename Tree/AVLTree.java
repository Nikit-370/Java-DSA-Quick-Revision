package Tree;

/*
--------------------------------------------------
Data Structure: AVL Tree

Description:
AVL Tree is a Self-Balancing Binary Search Tree.

Balance Factor:
Height(Left Subtree) - Height(Right Subtree)

Balance Factor must be:
-1, 0, or 1

Rotations:
1. Left Rotation
2. Right Rotation
3. Left-Right Rotation
4. Right-Left Rotation

Operations:
1. Insert Node
2. Delete Node
3. Search Node
4. Left Rotation
5. Right Rotation
6. Get Height
7. Get Balance Factor
8. Inorder Traversal
9. Preorder Traversal
10. Postorder Traversal

Time Complexity:
Insert  : O(log n)
Delete  : O(log n)
Search  : O(log n)

Space Complexity:
O(n)
--------------------------------------------------
*/

public class AVLTree {

    /*
    --------------------------------------------------
    AVL Node Class
    --------------------------------------------------
    */

    class Node {

        int data;
        int height;

        Node left;
        Node right;

        Node(int data) {

            this.data = data;

            height = 1;

            left = null;
            right = null;
        }
    }

    Node root;

    /*
    --------------------------------------------------
    1. Get Height
    --------------------------------------------------
    */

    int height(Node node) {

        if (node == null) {
            return 0;
        }

        return node.height;
    }

    /*
    --------------------------------------------------
    2. Get Balance Factor
    --------------------------------------------------
    */

    int getBalance(Node node) {

        if (node == null) {
            return 0;
        }

        return height(node.left)
                - height(node.right);
    }

    /*
    --------------------------------------------------
    3. Right Rotation
    --------------------------------------------------
    */

    Node rightRotate(Node y) {

        // Step 1: Store left child
        Node x = y.left;

        // Step 2: Store subtree
        Node t2 = x.right;

        // Step 3: Perform rotation
        x.right = y;
        y.left = t2;

        // Step 4: Update heights
        y.height = Math.max(height(y.left),
                height(y.right)) + 1;

        x.height = Math.max(height(x.left),
                height(x.right)) + 1;

        // Step 5: Return new root
        return x;
    }

    /*
    --------------------------------------------------
    4. Left Rotation
    --------------------------------------------------
    */

    Node leftRotate(Node x) {

        // Step 1: Store right child
        Node y = x.right;

        // Step 2: Store subtree
        Node t2 = y.left;

        // Step 3: Perform rotation
        y.left = x;
        x.right = t2;

        // Step 4: Update heights
        x.height = Math.max(height(x.left),
                height(x.right)) + 1;

        y.height = Math.max(height(y.left),
                height(y.right)) + 1;

        // Step 5: Return new root
        return y;
    }

    /*
    --------------------------------------------------
    5. Insert Node
    --------------------------------------------------
    */

    Node insert(Node node, int data) {

        // Step 1: Normal BST insertion
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        }

        else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        else {
            return node;
        }

        // Step 2: Update height
        node.height = 1 + Math.max(
                height(node.left),
                height(node.right));

        // Step 3: Find balance factor
        int balance = getBalance(node);

        /*
        --------------------------------------------------
        AVL Rotations
        --------------------------------------------------
        */

        // Left Left Case
        if (balance > 1
                && data < node.left.data) {

            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1
                && data > node.right.data) {

            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1
                && data > node.left.data) {

            node.left = leftRotate(node.left);

            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1
                && data < node.right.data) {

            node.right = rightRotate(node.right);

            return leftRotate(node);
        }

        return node;
    }

    /*
    --------------------------------------------------
    6. Search Node
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
    7. Find Minimum Node
    --------------------------------------------------
    */

    Node minValueNode(Node node) {

        Node current = node;

        // Step 1: Traverse left subtree
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    /*
    --------------------------------------------------
    8. Delete Node
    --------------------------------------------------
    */

    Node delete(Node root, int key) {

        // Step 1: Perform BST delete
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        }

        else if (key > root.data) {
            root.right = delete(root.right, key);
        }

        else {

            // One child or no child
            if ((root.left == null)
                    || (root.right == null)) {

                Node temp;

                if (root.left != null) {
                    temp = root.left;
                }

                else {
                    temp = root.right;
                }

                // No child case
                if (temp == null) {
                    root = null;
                }

                // One child case
                else {
                    root = temp;
                }
            }

            // Two children
            else {

                Node temp = minValueNode(root.right);

                root.data = temp.data;

                root.right = delete(root.right,
                        temp.data);
            }
        }

        // Tree had one node
        if (root == null) {
            return root;
        }

        // Step 2: Update height
        root.height = Math.max(
                height(root.left),
                height(root.right)) + 1;

        // Step 3: Get balance factor
        int balance = getBalance(root);

        /*
        --------------------------------------------------
        AVL Rotations After Delete
        --------------------------------------------------
        */

        // Left Left Case
        if (balance > 1
                && getBalance(root.left) >= 0) {

            return rightRotate(root);
        }

        // Left Right Case
        if (balance > 1
                && getBalance(root.left) < 0) {

            root.left = leftRotate(root.left);

            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1
                && getBalance(root.right) <= 0) {

            return leftRotate(root);
        }

        // Right Left Case
        if (balance < -1
                && getBalance(root.right) > 0) {

            root.right = rightRotate(root.right);

            return leftRotate(root);
        }

        return root;
    }

    /*
    --------------------------------------------------
    9. Inorder Traversal
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
    10. Preorder Traversal
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
    11. Postorder Traversal
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
}