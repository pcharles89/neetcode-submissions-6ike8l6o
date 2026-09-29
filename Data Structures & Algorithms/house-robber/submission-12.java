class Solution {
    public int rob(int[] nums) {
        int oneBack = 0;
        int twoBack = 0;

        for(int i = 0; i < nums.length; i++){
            int current = Math.max(oneBack, twoBack + nums[i]);

            twoBack = oneBack;
            oneBack = current;

        }

        return oneBack;
    }
}
