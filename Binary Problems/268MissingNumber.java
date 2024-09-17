// import java.util.HashSet;

// class Solution {
//     public int missingNumber(int[] nums) {

//         HashSet<Integer> newMap = new HashSet<>();
//         for (int v : nums) {
//             newMap.add(v);
//         }

//         for (int i = 0; i < nums.length; i++) {
//             if (!newMap.contains(i)) {
//                 return i;
//             }
//         }
//         return nums.length;
//     }
// }

// class Solution {
//     public int missingNumber(int[] nums) {
//         int sumArr = 0;
//         for(int v: nums){
//             sumArr+=v;
//         }
//         return (nums.length+1)*nums.length/2 - sumArr;
//     }
// }

class Solution {
    // XOR
    /*
     * 1^1 = 0
     * 1^2^1 = 2
     */
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for(int i = 0; i<nums.length;i++){
            result+=(i-nums[i]);
        }
        return result;
    }   
}

