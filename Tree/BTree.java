package Tree;

/*
--------------------------------------------------
Data Structure: B Tree

Description:
B Tree is a self-balancing multi-way tree
used in databases and file systems.

Properties:
- Multiple keys per node
- Multiple children
- Balanced tree
- Sorted keys

Operations:
1. Insert Key
2. Search Key
3. Split Child
4. Traverse Tree

Time Complexity:
Search : O(log n)
Insert : O(log n)

Space Complexity:
O(n)
--------------------------------------------------
*/

public class BTree {

    /*
    --------------------------------------------------
    B Tree Node Class
    --------------------------------------------------
    */

    class Node {

        int[] keys;

        int degree;

        Node[] children;

        int keyCount;

        boolean isLeaf;

        // Constructor
        Node(int degree, boolean isLeaf) {

            this.degree = degree;

            this.isLeaf = isLeaf;

            keys = new int[2 * degree - 1];

            children = new Node[2 * degree];

            keyCount = 0;
        }

        /*
        --------------------------------------------------
        Traverse Tree
        --------------------------------------------------
        */

        void traverse() {

            int i;

            // Traverse keys and children
            for (i = 0; i < keyCount; i++) {

                if (!isLeaf) {
                    children[i].traverse();
                }

                System.out.print(keys[i] + " ");
            }

            // Traverse last child
            if (!isLeaf) {
                children[i].traverse();
            }
        }

        /*
        --------------------------------------------------
        Search Key
        --------------------------------------------------
        */

        Node search(int key) {

            int i = 0;

            // Find key position
            while (i < keyCount
                    && key > keys[i]) {

                i++;
            }

            // Key found
            if (i < keyCount
                    && keys[i] == key) {

                return this;
            }

            // Key not found
            if (isLeaf) {
                return null;
            }

            // Search child node
            return children[i].search(key);
        }

        /*
        --------------------------------------------------
        Insert Into Non-Full Node
        --------------------------------------------------
        */

        void insertNonFull(int key) {

            int i = keyCount - 1;

            // Leaf node
            if (isLeaf) {

                // Shift greater keys
                while (i >= 0
                        && keys[i] > key) {

                    keys[i + 1] = keys[i];

                    i--;
                }

                // Insert key
                keys[i + 1] = key;

                keyCount++;
            }

            // Internal node
            else {

                // Find child index
                while (i >= 0
                        && keys[i] > key) {

                    i--;
                }

                i++;

                // Split full child
                if (children[i].keyCount
                        == 2 * degree - 1) {

                    splitChild(i, children[i]);

                    if (keys[i] < key) {
                        i++;
                    }
                }

                children[i].insertNonFull(key);
            }
        }

        /*
        --------------------------------------------------
        Split Child
        --------------------------------------------------
        */

        void splitChild(int index, Node y) {

            // Create new node
            Node z = new Node(y.degree,
                    y.isLeaf);

            // Store middle degree
            z.keyCount = degree - 1;

            // Copy keys
            for (int j = 0;
                 j < degree - 1;
                 j++) {

                z.keys[j]
                        = y.keys[j + degree];
            }

            // Copy children
            if (!y.isLeaf) {

                for (int j = 0;
                     j < degree;
                     j++) {

                    z.children[j]
                            = y.children[j + degree];
                }
            }

            // Reduce key count
            y.keyCount = degree - 1;

            // Shift children
            for (int j = keyCount;
                 j >= index + 1;
                 j--) {

                children[j + 1]
                        = children[j];
            }

            children[index + 1] = z;

            // Shift keys
            for (int j = keyCount - 1;
                 j >= index;
                 j--) {

                keys[j + 1] = keys[j];
            }

            // Move middle key upward
            keys[index]
                    = y.keys[degree - 1];

            keyCount++;
        }
    }

    Node root;

    int degree;

    // Constructor
    BTree(int degree) {

        this.degree = degree;

        root = null;
    }

    /*
    --------------------------------------------------
    1. Traverse Tree
    --------------------------------------------------
    */

    void traverse() {

        if (root != null) {
            root.traverse();
        }
    }

    /*
    --------------------------------------------------
    2. Search Key
    --------------------------------------------------
    */

    Node search(int key) {

        if (root == null) {
            return null;
        }

        return root.search(key);
    }

    /*
    --------------------------------------------------
    3. Insert Key
    --------------------------------------------------
    */

    void insert(int key) {

        // Empty tree
        if (root == null) {

            root = new Node(degree, true);

            root.keys[0] = key;

            root.keyCount = 1;
        }

        else {

            // Root full
            if (root.keyCount
                    == 2 * degree - 1) {

                Node s =
                        new Node(degree, false);

                s.children[0] = root;

                s.splitChild(0, root);

                int i = 0;

                if (s.keys[0] < key) {
                    i++;
                }

                s.children[i]
                        .insertNonFull(key);

                root = s;
            }

            // Root not full
            else {

                root.insertNonFull(key);
            }
        }
    }
}