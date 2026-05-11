package Tree;

public class BTreeDriver {

    public static void main(String[] args) {

        // Step 1: Create B Tree
        BTree tree = new BTree(3);

        // --------------------------------------------------
        // 1. Insert Keys
        // --------------------------------------------------

        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        tree.insert(7);
        tree.insert(17);

        // --------------------------------------------------
        // 2. Traverse Tree
        // --------------------------------------------------

        System.out.print("B Tree Traversal: ");

        tree.traverse();

        System.out.println();

        // --------------------------------------------------
        // 3. Search Keys
        // --------------------------------------------------

        if (tree.search(6) != null) {

            System.out.println(
                    "Key 6 Found");
        }

        else {

            System.out.println(
                    "Key 6 Not Found");
        }

        if (tree.search(15) != null) {

            System.out.println(
                    "Key 15 Found");
        }

        else {

            System.out.println(
                    "Key 15 Not Found");
        }
    }
}