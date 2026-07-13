class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile : piles){
            right = Math.max(pile, right);
        }

        while(left < right){
            long hours = 0;
            int mid = left + (right - left) / 2;

            for(int pile : piles){
                hours += pile / mid;

                if(pile % mid != 0){
                    hours++;
                }
            }

            if(hours <= h){
                right = mid;
            }

            else{
                left = mid + 1;
            }
            
        }

        return left;
    }
}
