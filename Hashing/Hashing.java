package Hashing;

/*
--------------------------------------------------
Data Structure: Hashing

Description:
Hashing is a technique used to store and
retrieve data quickly using a hash function.

Components:
- Key
- Value
- Hash Function
- Hash Table

Collision Handling:
- Linear Probing
- Chaining

Applications:
- HashMap
- HashSet
- Database Indexing
- Searching

Average Time Complexity:
Insert: O(1)
Search: O(1)
Delete: O(1)

Worst Case:
O(n)
--------------------------------------------------
*/

public class Hashing {

    int[] table; // Step 1: Hash table array
    int size; // Step 2: Table size

    // Constructor
    Hashing(int size) {

        // Step 3: Initialize size
        this.size = size;

        // Step 4: Create hash table
        table = new int[size];

        // Step 5: Fill with -1
        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
    }

    // Hash Function
    int hashFunction(int key) {

        // Step 1: Generate index
        return key % size;
    }

    // Insert using Linear Probing
    void insert(int key) {

        // Step 1: Get hash index
        int index = hashFunction(key);

        // Step 2: Find empty position
        while (table[index] != -1) {

            // Linear probing
            index = (index + 1) % size;
        }

        // Step 3: Insert key
        table[index] = key;
    }

    // Search key
    boolean search(int key) {

        // Step 1: Get hash index
        int index = hashFunction(key);

        // Step 2: Store starting index
        int start = index;

        // Step 3: Traverse table
        while (table[index] != -1) {

            // Step 4: Key found
            if (table[index] == key) {
                return true;
            }

            // Linear probing
            index = (index + 1) % size;

            // Full cycle completed
            if (index == start) {
                break;
            }
        }

        // Step 5: Key not found
        return false;
    }

    // Display hash table
    void show() {

        // Step 1: Traverse table
        for (int i = 0; i < size; i++) {

            System.out.println(i + " -> " + table[i]);
        }
    }
}