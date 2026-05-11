package Tree;

public class Driver {

    public static void main(String[] args) {

        // Step 1: Create TreeOperations object
        BinaryTree tree = new BinaryTree();

        // Step 2: Create tree manually

        tree.root = new Node(10);

        tree.root.left = new Node(20);
        tree.root.right = new Node(30);

        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);

        /*
                    10
                   /  \
                 20    30
                / \
              40  50
        */

        // --------------------------------------------------
        // 1. Inorder Traversal
        // --------------------------------------------------

        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);

        System.out.println();

        // --------------------------------------------------
        // 2. Preorder Traversal
        // --------------------------------------------------

        System.out.print("Preorder Traversal: ");
        tree.preorder(tree.root);

        System.out.println();

        // --------------------------------------------------
        // 3. Postorder Traversal
        // --------------------------------------------------

        System.out.print("Postorder Traversal: ");
        tree.postorder(tree.root);

        System.out.println();

        // --------------------------------------------------
        // 4. Level Order Traversal
        // --------------------------------------------------

        System.out.print("Level Order Traversal: ");
        tree.levelOrder();

        System.out.println();

        // --------------------------------------------------
        // 5. Count Total Nodes
        // --------------------------------------------------

        System.out.println("Total Nodes: "
                + tree.countNodes(tree.root));

        // --------------------------------------------------
        // 6. Count Leaf Nodes
        // --------------------------------------------------

        System.out.println("Leaf Nodes: "
                + tree.countLeafNodes(tree.root));

        // --------------------------------------------------
        // 7. Height of Tree
        // --------------------------------------------------

        System.out.println("Height of Tree: "
                + tree.height(tree.root));

        // --------------------------------------------------
        // 8. Search Element
        // --------------------------------------------------

        System.out.println("Search 50: "
                + tree.search(tree.root, 50));

        System.out.println("Search 100: "
                + tree.search(tree.root, 100));

        // --------------------------------------------------
        // 9. Find Minimum Node
        // --------------------------------------------------

        System.out.println("Minimum Node: "
                + tree.findMin(tree.root));

        // --------------------------------------------------
        // 10. Find Maximum Node
        // --------------------------------------------------

        System.out.println("Maximum Node: "
                + tree.findMax(tree.root));
    }
}