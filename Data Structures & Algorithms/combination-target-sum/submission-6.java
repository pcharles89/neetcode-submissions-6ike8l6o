class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();

        backtrack(nums, target, 0, combo, res);
        return res;
    }

    private void backtrack(int[] nums, int target, int index, List<Integer> combo, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(combo));
            return;
        }

        if(index == nums.length || target < 0){
            return;
        }

        combo.add(nums[index]);
        backtrack(nums, target - nums[index], index, combo, res);
        combo.remove(combo.size() - 1);
        
        backtrack(nums, target, index + 1, combo, res);
        
    }
}
