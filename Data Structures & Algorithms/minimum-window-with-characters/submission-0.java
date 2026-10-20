
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int[] count = new int[128];

        for (char c : t.toCharArray()) {
            count[c]++;
        }

        int remaining = t.length();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            if (count[rightChar] > 0) {
                remaining--;
            }

            count[rightChar]--;

            while (remaining == 0) {
                int windowLength = right - left + 1;

                if (windowLength < minLength) {
                    minLength = windowLength;
                    start = left;
                }

                char leftChar = s.charAt(left);
                count[leftChar]++;

                if (count[leftChar] > 0) {
                    remaining++;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}

