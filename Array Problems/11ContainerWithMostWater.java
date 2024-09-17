class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int result = 0;

        while (l < r) {
            result = Math.max(result, areaCalc(height, l, r));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return result;

    }

    public int areaCalc(int[] height, int l, int r) {
        return Math.min(height[l], height[r]) * (r - l);
    }
}