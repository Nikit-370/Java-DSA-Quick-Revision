package Tree;

public class HeapDriver {

    public static void main(String[] args) {

        // Step 1: Create MaxHeap object
        MaxHeap heap = new MaxHeap(10);

        // --------------------------------------------------
        // 1. Insert Elements
        // --------------------------------------------------

        heap.insert(50);
        heap.insert(30);
        heap.insert(40);
        heap.insert(10);
        heap.insert(20);
        heap.insert(60);

        /*
                    60
                   /  \
                 30    50
                / \    /
              10  20  40
        */

        // --------------------------------------------------
        // 2. Display Heap
        // --------------------------------------------------

        System.out.print("Heap Elements: ");
        heap.show();

        System.out.println();

        // --------------------------------------------------
        // 3. Peek Maximum Element
        // --------------------------------------------------

        System.out.println("Maximum Element: "
                + heap.peek());

        // --------------------------------------------------
        // 4. Extract Maximum Element
        // --------------------------------------------------

        System.out.println("Extracted Maximum: "
                + heap.extractMax());

        // --------------------------------------------------
        // 5. Display After Extraction
        // --------------------------------------------------

        System.out.print("Heap After Extraction: ");
        heap.show();

        System.out.println();

        // --------------------------------------------------
        // 6. Delete Root Node
        // --------------------------------------------------

        heap.delete();

        System.out.print("Heap After Delete: ");
        heap.show();

        System.out.println();

        // --------------------------------------------------
        // 7. Heap Sort
        // --------------------------------------------------

        heap.heapSort();
    }
}