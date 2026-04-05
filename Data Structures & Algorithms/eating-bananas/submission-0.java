class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int p : piles) right = Math.max(right, p);

        while (left < right) {
            int mid = left + (right - left) / 2; // candidate speed
            if (canFinish(piles, h, mid)) {
                right = mid;        // mid works, try smaller
            } else {
                left = mid + 1;     // mid too slow, need bigger
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0; // long to avoid overflow
        for (int p : piles) {
            // ceil(p / k) without floating point:
            hours += (p + k - 1) / k;
            if (hours > h) return false; // small optimization
        }
        return hours <= h;
    }
}

