package Tree;

/*
--------------------------------------------------
Data Structure: Trie Tree

Description:
Trie is a special tree used for storing strings.

Each node stores:
- Characters
- End of word flag

Applications:
- Dictionary
- Auto Complete
- Spell Checker
- Prefix Search

Operations:
1. Insert Word
2. Search Word
3. Prefix Search
4. Delete Word
5. Display All Words
6. Count Total Words

Time Complexity:
Insert  : O(n)
Search  : O(n)
Delete  : O(n)

n = length of word

Space Complexity:
O(ALPHABET_SIZE * N)
--------------------------------------------------
*/

public class TrieTree {

    /*
    --------------------------------------------------
    Trie Node Class
    --------------------------------------------------
    */

    class TrieNode {

        TrieNode[] children;

        boolean isEndOfWord;

        // Constructor
        TrieNode() {

            // Step 1: Create 26 child references
            children = new TrieNode[26];

            // Step 2: Initially false
            isEndOfWord = false;
        }
    }

    TrieNode root;

    // Constructor
    TrieTree() {

        root = new TrieNode();
    }

    /*
    --------------------------------------------------
    1. Insert Word
    --------------------------------------------------
    */

    void insert(String word) {

        // Step 1: Start from root
        TrieNode current = root;

        // Step 2: Traverse characters
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            int index = ch - 'a';

            // Step 3: Create node if absent
            if (current.children[index] == null) {

                current.children[index]
                        = new TrieNode();
            }

            // Step 4: Move to next node
            current = current.children[index];
        }

        // Step 5: Mark end of word
        current.isEndOfWord = true;
    }

    /*
    --------------------------------------------------
    2. Search Word
    --------------------------------------------------
    */

    boolean search(String word) {

        // Step 1: Start from root
        TrieNode current = root;

        // Step 2: Traverse word
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            int index = ch - 'a';

            // Step 3: Word not found
            if (current.children[index] == null) {
                return false;
            }

            // Step 4: Move to next node
            current = current.children[index];
        }

        // Step 5: Return end-of-word status
        return current.isEndOfWord;
    }

    /*
    --------------------------------------------------
    3. Prefix Search
    --------------------------------------------------
    */

    boolean startsWith(String prefix) {

        // Step 1: Start from root
        TrieNode current = root;

        // Step 2: Traverse prefix
        for (int i = 0; i < prefix.length(); i++) {

            char ch = prefix.charAt(i);

            int index = ch - 'a';

            // Step 3: Prefix not found
            if (current.children[index] == null) {
                return false;
            }

            // Step 4: Move forward
            current = current.children[index];
        }

        return true;
    }

    /*
    --------------------------------------------------
    4. Delete Word
    --------------------------------------------------
    */

    boolean delete(TrieNode current,
                   String word,
                   int depth) {

        // Step 1: Word completed
        if (depth == word.length()) {

            // Word not present
            if (!current.isEndOfWord) {
                return false;
            }

            // Remove end-of-word mark
            current.isEndOfWord = false;

            // Check empty node
            return isEmpty(current);
        }

        // Step 2: Find character index
        int index = word.charAt(depth) - 'a';

        TrieNode node = current.children[index];

        // Word not found
        if (node == null) {
            return false;
        }

        // Step 3: Recursive delete
        boolean shouldDelete =
                delete(node, word, depth + 1);

        // Step 4: Delete node reference
        if (shouldDelete) {

            current.children[index] = null;

            return !current.isEndOfWord
                    && isEmpty(current);
        }

        return false;
    }

    /*
    --------------------------------------------------
    Helper Method: Check Empty Node
    --------------------------------------------------
    */

    boolean isEmpty(TrieNode node) {

        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null) {
                return false;
            }
        }

        return true;
    }

    /*
    --------------------------------------------------
    5. Display All Words
    --------------------------------------------------
    */

    void display(TrieNode node, String word) {

        // Step 1: Word completed
        if (node.isEndOfWord) {

            System.out.println(word);
        }

        // Step 2: Traverse children
        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null) {

                char ch = (char) (i + 'a');

                display(node.children[i],
                        word + ch);
            }
        }
    }

    /*
    --------------------------------------------------
    6. Count Total Words
    --------------------------------------------------
    */

    int countWords(TrieNode node) {

        int count = 0;

        // Step 1: Count current word
        if (node.isEndOfWord) {
            count++;
        }

        // Step 2: Traverse children
        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null) {

                count += countWords(
                        node.children[i]);
            }
        }

        return count;
    }
}