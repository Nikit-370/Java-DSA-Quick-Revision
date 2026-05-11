package Tree;

public class BSTDriver {

    public static void main(String[] args) {

        // Step 1: Create BST object
        BST bst = new BST();

        // Step 2: Insert nodes
        bst.root = bst.insert(bst.root, 50);
        bst.root = bst.insert(bst.root, 30);
        bst.root = bst.insert(bst.root, 70);
        bst.root = bst.insert(bst.root, 20);
        bst.root = bst.insert(bst.root, 40);
        bst.root = bst.insert(bst.root, 60);
        bst.root = bst.insert(bst.root, 80);

        /*
                    50
                   /  \
                 30    70
                / \    / \
              20  40  60  80
        */

        // --------------------------------------------------
        // 1. Inorder Traversal
        // --------------------------------------------------

        System.out.print("Inorder Traversal: ");
        bst.inorder(bst.root);

        System.out.println();

        // --------------------------------------------------
        // 2. Preorder Traversal
        // --------------------------------------------------

        System.out.print("Preorder Traversal: ");
        bst.preorder(bst.root);

        System.out.println();

        // --------------------------------------------------
        // 3. Postorder Traversal
        // --------------------------------------------------

        System.out.print("Postorder Traversal: ");
        bst.postorder(bst.root);

        System.out.println();

        // --------------------------------------------------
        // 4. Search Node
        // --------------------------------------------------

        System.out.println("Search 40: "
                + bst.search(bst.root, 40));

        System.out.println("Search 100: "
                + bst.search(bst.root, 100));

        // --------------------------------------------------
        // 5. Find Minimum
        // --------------------------------------------------

        System.out.println("Minimum Node: "
                + bst.findMin(bst.root));

        // --------------------------------------------------
        // 6. Find Maximum
        // --------------------------------------------------

        System.out.println("Maximum Node: "
                + bst.findMax(bst.root));

        // --------------------------------------------------
        // 7. Count Total Nodes
        // --------------------------------------------------

        System.out.println("Total Nodes: "
                + bst.countNodes(bst.root));

        // --------------------------------------------------
        // 8. Height of Tree
        // --------------------------------------------------

        System.out.println("Height of Tree: "
                + bst.height(bst.root));

        // --------------------------------------------------
        // 9. Delete Node
        // --------------------------------------------------

        bst.root = bst.delete(bst.root, 70);

        System.out.print("After Deleting 70: ");
        bst.inorder(bst.root);
    }
}