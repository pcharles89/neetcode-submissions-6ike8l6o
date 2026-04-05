class Solution {
    public boolean isPalindrome(String s) {
        char[] sArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(Character x : sArray){
            if(Character.isLetterOrDigit(x)){
                sb.append(x);
            }
        }

        String s1 = new String(sb).toLowerCase();
        sb.reverse();
        String s2 = new String(sb).toLowerCase();
        
        if(s1.equals(s2)){
            return true;
        }

        return false;

    }
}
