package Tree;

/*
--------------------------------------------------
Data Structure: Fenwick Tree
(Binary Indexed Tree)

Description:
Fenwick Tree is used for efficient
prefix sum calculations and updates.

Operations:
1. Build Tree
2. Update Element
3. Prefix Sum Query
4. Range Sum Query
5. Display Tree

Time Complexity:
Update      : O(log n)
Prefix Sum  : O(log n)
Range Query : O(log n)

Space Complexity:
O(n)
--------------------------------------------------
*/

public class FenwickTree {

    int[] tree; // Step 1: Fenwick tree array

    int size; // Step 2: Size of tree

    // Constructor
    FenwickTree(int n) {

        // Step 1: Store size
        size = n;

        // Step 2: Create tree array
        tree = new int[n + 1];
    }

    /*
    --------------------------------------------------
    1. Update Element
    --------------------------------------------------
    */

    void update(int index, int value) {

        // Step 1: Convert to 1-based index
        index++;

        // Step 2: Update all responsible nodes
        while (index <= size) {

            tree[index] += value;

            // Move to next index
            index += index & (-index);
        }
    }

    /*
    --------------------------------------------------
    2. Prefix Sum Query
    --------------------------------------------------
    */

    int prefixSum(int index) {

        // Step 1: Convert to 1-based index
        index++;

        int sum = 0;

        // Step 2: Traverse parent nodes
        while (index > 0) {

            sum += tree[index];

            // Move to parent
            index -= index & (-index);
        }

        // Step 3: Return sum
        return sum;
    }

    /*
    --------------------------------------------------
    3. Range Sum Query
    --------------------------------------------------
    */

    int rangeSum(int left, int right) {

        // Step 1: Prefix(right) - Prefix(left-1)
        return prefixSum(right)
                - prefixSum(left - 1);
    }

    /*
    --------------------------------------------------
    4. Build Tree
    --------------------------------------------------
    */

    void buildTree(int[] arr) {

        // Step 1: Insert all elements
        for (int i = 0; i < arr.length; i++) {

            update(i, arr[i]);
        }
    }

    /*
    --------------------------------------------------
    5. Display Fenwick Tree
    --------------------------------------------------
    */

    void show() {

        // Step 1: Traverse tree
        for (int i = 1; i <= size; i++) {

            System.out.print(tree[i] + " ");
        }
    }
}