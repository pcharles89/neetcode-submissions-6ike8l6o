class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(0, nums, subset, result);
        return result;
    }

    private void backtrack(int i, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // include nums[i]
        subset.add(nums[i]);
        backtrack(i + 1, nums, subset, result);

        // exclude nums[i]
        subset.remove(subset.size() - 1);
        backtrack(i + 1, nums, subset, result);
    }
}