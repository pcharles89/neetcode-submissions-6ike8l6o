class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        backtrack(0, nums, sub, res);

        return res;
    }

    private void backtrack(int i, int[] nums, 
    List<Integer> sub, List<List<Integer>> res){
        if(i == nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[i]);
        backtrack(i + 1, nums, sub, res);
        
        sub.remove(sub.size() - 1);
        backtrack(i + 1, nums, sub, res);
    }
}
