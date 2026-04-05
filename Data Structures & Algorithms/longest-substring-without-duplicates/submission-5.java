class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hash_set = new HashSet<>();
        int a_pointer = 0;
        int b_pointer = 0;
        int res = 0;

        while(b_pointer < s.length()){
            if(!hash_set.contains(s.charAt(b_pointer))){
             hash_set.add(s.charAt(b_pointer));
             res = Math.max(hash_set.size(), res);
             b_pointer++;
            }
            else{
                hash_set.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return res;
    }
}
