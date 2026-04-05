class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int x : nums){
            if(seen.contains(x)){
                return true;
            }
            seen.add(x);
        }
        return false;
    }
}