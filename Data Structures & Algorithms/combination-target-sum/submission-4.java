class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        backtrack(candidates, target, 0, combination, result);

        return result;
    }

    private void backtrack(int[] candidates, int target, int index,
                           List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        combination.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, combination, result);
        combination.remove(combination.size() - 1);

        backtrack(candidates, target, index + 1, combination, result);
    }
}
