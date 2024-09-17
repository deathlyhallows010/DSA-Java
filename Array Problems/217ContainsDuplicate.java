import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> newMap = new HashSet<>();
        for(int v: nums){
            if(newMap.contains(v)){
                return true;
            }
            else{
                newMap.add(v);
            }
        }
        return false;
    }
}