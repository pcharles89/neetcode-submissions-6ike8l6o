class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        int index1 = -1;
        int index2 = 0;
        for(int i = 0; i < nums.length; i++) {
            index1++;
            index2 = index1 + 1;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    solution[0] = index1;
                    solution[1] = index2; 
                }
                index2++;
            }
        }
        return solution;
    }
}
