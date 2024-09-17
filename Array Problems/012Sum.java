import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> newMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            newMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (newMap.containsKey(complement) && newMap.get(complement) != i) {
                return new int[] { i, newMap.get(complement) };
            }
        }
        return null;
    }
}