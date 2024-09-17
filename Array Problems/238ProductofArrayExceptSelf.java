class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arraylen = nums.length;
        int[] output = new int[arraylen];

        int prefix = 1;
        for(int i =0;i<arraylen;i++){
            output[i] = prefix;
            prefix*=nums[i];
        }
        int postfix = 1;
        for(int i =arraylen-1;i>=0;i--){
            output[i] *= postfix;
            postfix*=nums[i];
        }

        return output;
    }
}