class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer> numsSet = new HashSet<>();
       
       for(int x : nums){
        numsSet.add(x);
       }

       int res = 0;

       for(int number : numsSet){
            int length = 1;
          if(!numsSet.contains(number - length)){
            while(numsSet.contains(number + length)){
                length++;
            }
          }
          res = Math.max(res, length);
       }

        return res;

    }
}


