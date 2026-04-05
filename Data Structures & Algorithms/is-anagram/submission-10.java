class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();

        Arrays.sort(arrayS);
        Arrays.sort(arrayT);

       StringBuilder sb1 = new StringBuilder(Arrays.toString(arrayS));
       StringBuilder sb2 = new StringBuilder(Arrays.toString(arrayT));

       return sb1.toString().equals(sb2.toString());
}
}
