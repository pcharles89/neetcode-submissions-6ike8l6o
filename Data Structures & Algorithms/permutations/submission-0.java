class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, perm, result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> perm, List<List<Integer>> result) {
        if (perm.size() == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            perm.add(nums[i]);
            used[i] = true;

            backtrack(nums, used, perm, result);

            perm.remove(perm.size() - 1);
            used[i] = false;
        }
    }
}
