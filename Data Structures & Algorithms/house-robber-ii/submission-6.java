class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int skipLast = rob(nums, 0, nums.length - 2);
        int skipFirst = rob(nums, 1, nums.length - 1);

        return Math.max(skipLast, skipFirst);
    }

    private int rob(int[] nums, int start, int end){

        int twoBack = 0;
        int oneBack = 0;

        for(int i = start; i <= end; i++){
            int current = Math.max(oneBack, twoBack + nums[i]);

            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
        
    }
}
