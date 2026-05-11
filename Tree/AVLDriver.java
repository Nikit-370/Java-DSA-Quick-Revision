package Tree;

public class AVLDriver {

    public static void main(String[] args) {

        // Step 1: Create AVL Tree object
        AVLTree tree = new AVLTree();

        // --------------------------------------------------
        // 1. Insert Nodes
        // --------------------------------------------------

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /*
                    30
                   /  \
                 20    40
                / \      \
              10  25      50
        */

        // --------------------------------------------------
        // 2. Inorder Traversal
        // --------------------------------------------------

        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);

        System.out.println();

        // --------------------------------------------------
        // 3. Preorder Traversal
        // --------------------------------------------------

        System.out.print("Preorder Traversal: ");
        tree.preorder(tree.root);

        System.out.println();

        // --------------------------------------------------
        // 4. Postorder Traversal
        // --------------------------------------------------

        System.out.print("Postorder Traversal: ");
        tree.postorder(tree.root);

        System.out.println();

        // --------------------------------------------------
        // 5. Search Node
        // --------------------------------------------------

        System.out.println("Search 25: "
                + tree.search(tree.root, 25));

        System.out.println("Search 100: "
                + tree.search(tree.root, 100));

        // --------------------------------------------------
        // 6. Delete Node
        // --------------------------------------------------

        tree.root = tree.delete(tree.root, 40);

        System.out.print("After Deleting 40: ");
        tree.inorder(tree.root);

        System.out.println();

        // --------------------------------------------------
        // 7. Height of AVL Tree
        // --------------------------------------------------

        System.out.println("Height of Tree: "
                + tree.height(tree.root));

        // --------------------------------------------------
        // 8. Balance Factor of Root
        // --------------------------------------------------

        System.out.println("Balance Factor of Root: "
                + tree.getBalance(tree.root));
    }
}