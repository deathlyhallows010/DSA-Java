class Solution {
    // Bit Manipulation
    /*
     * a^b
     * 1 1 = 0
     * 0 0 = 0
     * 1 0 = 1
     * 0 1 = 1
     * 
     * Estimating carry by a & b
     * 
     * add + add (by carry) ans shift by one, and repeat
     */
    public int getSum(int a, int b) {
        while (b != 0){
            int temp = (a & b) << 1; // << bit shifted by one
            a = a ^ b;
            b = temp;
        }
        return a;
    }
}