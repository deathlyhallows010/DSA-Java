class Solution {

    // Sliding window
    // Remove negative prefix

    public int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int currSum = 0;
        for(int v: nums){
            if(currSum<0){
                currSum = 0;
            }
            currSum+=v;
            maxSub = Math.max(maxSub, currSum);
        }
        return maxSub;
    }
}