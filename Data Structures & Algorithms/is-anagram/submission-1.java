class Solution {
    public boolean isAnagram(String s, String t) {
        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars2);

        String one = new String(chars1);
        String two = new String(chars2);

        if(one.equals(two)){
            return true;
        }
        else {
            return false;
        }


    }
}
