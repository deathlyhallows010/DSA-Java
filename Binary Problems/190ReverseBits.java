class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        // Loop through all 32 bits
        for (int i = 0; i < 32; i++) {
            // Get the last bit of n (n & 1) and shift it to the left by (31 - i) positions
            result |= (n & 1) << (31 - i);
            // Shift n to the right to process the next bit
            n >>= 1;
        }
        return result;
    }
}