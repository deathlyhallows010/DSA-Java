class Solution {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        int m;

        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            }
            // Left sorted portion
            if (nums[m] >= nums[l]) {
                if (target > nums[m]) {
                    l = m + 1;
                } else if (target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
                // Right sorted portion
            } else {
                if (target < nums[m]) {
                    r = m - 1;
                } else if (target > nums[r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}