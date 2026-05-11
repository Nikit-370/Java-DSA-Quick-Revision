package BitManipulation;

public class Driver {

    public static void main(String[] args) {

        // Step 1: Create object
        BitManipulation bit = new BitManipulation();

        int num = 10;

        // Binary of 10 = 1010

        // Step 2: Check odd/even
        System.out.println("Is Odd: " + bit.isOdd(num));

        // Step 3: Get ith bit
        System.out.println("2nd Bit: " + bit.getBit(num, 2));

        // Step 4: Set ith bit
        System.out.println("Set 0th Bit: " + bit.setBit(num, 0));

        // Step 5: Clear ith bit
        System.out.println("Clear 1st Bit: " + bit.clearBit(num, 1));

        // Step 6: Toggle ith bit
        System.out.println("Toggle 3rd Bit: " + bit.toggleBit(num, 3));

        // Step 7: Count set bits
        System.out.println("Set Bits Count: " + bit.countSetBits(num));
    }
}