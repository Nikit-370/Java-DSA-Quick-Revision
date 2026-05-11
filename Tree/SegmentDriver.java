package Tree;

public class SegmentDriver {

    public static void main(String[] args) {

        // Step 1: Create array
        int[] arr = {1, 3, 5, 7, 9, 11};

        // Step 2: Create Segment Tree
        SegmentTree tree = new SegmentTree(arr);

        // --------------------------------------------------
        // 1. Display Segment Tree
        // --------------------------------------------------

        System.out.print("Segment Tree: ");
        tree.show();

        System.out.println();

        // --------------------------------------------------
        // 2. Total Array Sum
        // --------------------------------------------------

        System.out.println("Total Sum: "
                + tree.totalSum());

        // --------------------------------------------------
        // 3. Range Sum Query
        // --------------------------------------------------

        int sum = tree.rangeQuery(
                0,
                0,
                arr.length - 1,
                1,
                4);

        System.out.println("Range Sum (1 to 4): "
                + sum);

        // --------------------------------------------------
        // 4. Update Element
        // --------------------------------------------------

        tree.update(
                0,
                0,
                arr.length - 1,
                2,
                10);

        // --------------------------------------------------
        // 5. Range Query After Update
        // --------------------------------------------------

        int updatedSum = tree.rangeQuery(
                0,
                0,
                arr.length - 1,
                1,
                4);

        System.out.println(
                "Range Sum After Update: "
                + updatedSum);

        // --------------------------------------------------
        // 6. Display Updated Tree
        // --------------------------------------------------

        System.out.print("Updated Segment Tree: ");
        tree.show();
    }
}