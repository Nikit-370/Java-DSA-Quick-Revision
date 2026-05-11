package Tree;

/*
--------------------------------------------------
Data Structure: Segment Tree

Description:
Segment Tree is used for efficient
range queries and updates.

Applications:
- Range Sum Query
- Range Minimum Query
- Range Maximum Query

Operations:
1. Build Tree
2. Range Sum Query
3. Update Element
4. Display Segment Tree
5. Total Array Sum

Time Complexity:
Build Tree  : O(n)
Range Query : O(log n)
Update      : O(log n)

Space Complexity:
O(4n)
--------------------------------------------------
*/

public class SegmentTree {

    int[] tree; // Step 1: Segment tree array

    int[] arr; // Step 2: Original array

    int n; // Step 3: Array size

    // Constructor
    SegmentTree(int[] arr) {

        // Step 1: Store original array
        this.arr = arr;

        // Step 2: Store array size
        n = arr.length;

        // Step 3: Create segment tree
        tree = new int[4 * n];

        // Step 4: Build tree
        buildTree(0, 0, n - 1);
    }

    /*
    --------------------------------------------------
    1. Build Segment Tree
    --------------------------------------------------
    */

    void buildTree(int node,
                   int start,
                   int end) {

        // Step 1: Leaf node
        if (start == end) {

            tree[node] = arr[start];

            return;
        }

        // Step 2: Find middle index
        int mid = (start + end) / 2;

        // Step 3: Build left subtree
        buildTree(2 * node + 1,
                start,
                mid);

        // Step 4: Build right subtree
        buildTree(2 * node + 2,
                mid + 1,
                end);

        // Step 5: Store sum
        tree[node] = tree[2 * node + 1]
                   + tree[2 * node + 2];
    }

    /*
    --------------------------------------------------
    2. Range Sum Query
    --------------------------------------------------
    */

    int rangeQuery(int node,
                   int start,
                   int end,
                   int left,
                   int right) {

        // Step 1: No overlap
        if (right < start
                || left > end) {

            return 0;
        }

        // Step 2: Complete overlap
        if (left <= start
                && right >= end) {

            return tree[node];
        }

        // Step 3: Partial overlap
        int mid = (start + end) / 2;

        int leftSum = rangeQuery(
                2 * node + 1,
                start,
                mid,
                left,
                right);

        int rightSum = rangeQuery(
                2 * node + 2,
                mid + 1,
                end,
                left,
                right);

        // Step 4: Return total sum
        return leftSum + rightSum;
    }

    /*
    --------------------------------------------------
    3. Update Element
    --------------------------------------------------
    */

    void update(int node,
                int start,
                int end,
                int index,
                int value) {

        // Step 1: Leaf node reached
        if (start == end) {

            arr[index] = value;

            tree[node] = value;

            return;
        }

        // Step 2: Find middle index
        int mid = (start + end) / 2;

        // Step 3: Traverse left subtree
        if (index <= mid) {

            update(2 * node + 1,
                    start,
                    mid,
                    index,
                    value);
        }

        // Step 4: Traverse right subtree
        else {

            update(2 * node + 2,
                    mid + 1,
                    end,
                    index,
                    value);
        }

        // Step 5: Update parent node
        tree[node] = tree[2 * node + 1]
                   + tree[2 * node + 2];
    }

    /*
    --------------------------------------------------
    4. Display Segment Tree
    --------------------------------------------------
    */

    void show() {

        // Step 1: Traverse tree array
        for (int i = 0; i < 2 * n; i++) {

            System.out.print(tree[i] + " ");
        }
    }

    /*
    --------------------------------------------------
    5. Total Array Sum
    --------------------------------------------------
    */

    int totalSum() {

        // Root contains total sum
        return tree[0];
    }
}