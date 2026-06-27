class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> subsequence = new ArrayList<>();

        for (int num : nums) {
            int left = 0;
            int right = subsequence.size();

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (subsequence.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == subsequence.size()) {
                subsequence.add(num);
            } else {
                subsequence.set(left, num);
            }
        }

        return subsequence.size();
    }
}