class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // The maximum possible speed we need to consider
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            long hours = 0;

            // Calculate how many hours Koko needs at speed mid
            for (int pile : piles) {
                hours += pile / mid;

                // If bananas remain, Koko needs one additional hour
                if (pile % mid != 0) {
                    hours++;
                }
            }

            if (hours <= h) {
                // This speed works, but a slower speed might also work
                right = mid;
            } else {
                // This speed is too slow
                left = mid + 1;
            }
        }

        return left;
    }
}
