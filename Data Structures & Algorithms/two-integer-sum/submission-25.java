public class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            int diff = target - currNum;
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            else{
                map.put(currNum, i);
            }
        }
        return new int[]{};
    }
}