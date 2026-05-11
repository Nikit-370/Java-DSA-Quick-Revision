package BitManipulation;

/*
--------------------------------------------------
Concept: Bit Manipulation

Description:
Bit Manipulation is a technique used to perform
operations directly on binary bits.

Common Operations:
- AND (&)
- OR (|)
- XOR (^)
- NOT (~)
- Left Shift (<<)
- Right Shift (>>)

Applications:
- Check Odd/Even
- Swap Numbers
- Set/Clear/Toggle Bits
- Fast Calculations

Time Complexity:
O(1)

Space Complexity:
O(1)
--------------------------------------------------
*/

public class BitManipulation {

    // Check if number is even or odd
    boolean isOdd(int num) {

        // If last bit is 1 → Odd
        return (num & 1) == 1;
    }

    // Get ith bit
    int getBit(int num, int i) {

        // Create mask
        int mask = 1 << i;

        // Check bit using AND
        return (num & mask) != 0 ? 1 : 0;
    }

    // Set ith bit
    int setBit(int num, int i) {

        // Create mask
        int mask = 1 << i;

        // Set bit using OR
        return num | mask;
    }

    // Clear ith bit
    int clearBit(int num, int i) {

        // Create mask
        int mask = ~(1 << i);

        // Clear using AND
        return num & mask;
    }

    // Toggle ith bit
    int toggleBit(int num, int i) {

        // Create mask
        int mask = 1 << i;

        // Toggle using XOR
        return num ^ mask;
    }

    // Count number of set bits
    int countSetBits(int num) {

        int count = 0;

        // Traverse until number becomes 0
        while (num > 0) {

            // Check last bit
            count += (num & 1);

            // Right shift
            num = num >> 1;
        }

        return count;
    }
}