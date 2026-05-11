package Hashing;

public class Driver {

    public static void main(String[] args) {

        // Step 1: Create hash table
        Hashing hash = new Hashing(10);

        // Step 2: Insert elements
        hash.insert(15);
        hash.insert(25);
        hash.insert(35);
        hash.insert(12);

        // Step 3: Display hash table
        System.out.println("Hash Table:");
        hash.show();

        System.out.println();

        // Step 4: Search elements
        System.out.println("Search 25: "
                + hash.search(25));

        System.out.println("Search 50: "
                + hash.search(50));
    }
}