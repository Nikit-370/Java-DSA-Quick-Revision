package Tree;

public class TrieDriver {

    public static void main(String[] args) {

        // Step 1: Create Trie object
        TrieTree trie = new TrieTree();

        // --------------------------------------------------
        // 1. Insert Words
        // --------------------------------------------------

        trie.insert("cat");
        trie.insert("car");
        trie.insert("care");
        trie.insert("dog");
        trie.insert("door");

        // --------------------------------------------------
        // 2. Search Words
        // --------------------------------------------------

        System.out.println("Search cat: "
                + trie.search("cat"));

        System.out.println("Search cow: "
                + trie.search("cow"));

        // --------------------------------------------------
        // 3. Prefix Search
        // --------------------------------------------------

        System.out.println("Prefix ca: "
                + trie.startsWith("ca"));

        System.out.println("Prefix do: "
                + trie.startsWith("do"));

        System.out.println("Prefix xy: "
                + trie.startsWith("xy"));

        // --------------------------------------------------
        // 4. Display All Words
        // --------------------------------------------------

        System.out.println("\nWords in Trie:");

        trie.display(trie.root, "");

        // --------------------------------------------------
        // 5. Count Total Words
        // --------------------------------------------------

        System.out.println("\nTotal Words: "
                + trie.countWords(trie.root));

        // --------------------------------------------------
        // 6. Delete Word
        // --------------------------------------------------

        trie.delete(trie.root, "dog", 0);

        System.out.println("\nAfter Deleting dog:");

        trie.display(trie.root, "");
    }
}