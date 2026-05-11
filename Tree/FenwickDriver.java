package Tree;

public class FenwickDriver {

    public static void main(String[] args) {

        // Step 1: Create array
        int[] arr = {1, 2, 3, 4, 5};

        // Step 2: Create Fenwick Tree
        FenwickTree tree =
                new FenwickTree(arr.length);

        // --------------------------------------------------
        // 1. Build Tree
        // --------------------------------------------------

        tree.buildTree(arr);

        // --------------------------------------------------
        // 2. Display Tree
        // --------------------------------------------------

        System.out.print("Fenwick Tree: ");
        tree.show();

        System.out.println();

        // --------------------------------------------------
        // 3. Prefix Sum Query
        // --------------------------------------------------

        System.out.println("Prefix Sum (0 to 3): "
                + tree.prefixSum(3));

        // --------------------------------------------------
        // 4. Range Sum Query
        // --------------------------------------------------

        System.out.println("Range Sum (1 to 4): "
                + tree.rangeSum(1, 4));

        // --------------------------------------------------
        // 5. Update Element
        // --------------------------------------------------

        tree.update(2, 5);

        /*
        Added +5 at index 2
        Updated array becomes:
        [1, 2, 8, 4, 5]
        */

        // --------------------------------------------------
        // 6. Range Query After Update
        // --------------------------------------------------

        System.out.println(
                "Range Sum After Update: "
                + tree.rangeSum(1, 4));

        // --------------------------------------------------
        // 7. Display Updated Tree
        // --------------------------------------------------

        System.out.print("Updated Fenwick Tree: ");
        tree.show();
    }
}