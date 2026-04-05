public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        int l = 0;
        int r = people.length - 1;
        Arrays.sort(people);

        while(l <= r){
            int remain = limit - people[r--];
            res++;
            if(l <= r && people[l] <= remain){
                l++;
            }
        }
       return res; 
    }
}