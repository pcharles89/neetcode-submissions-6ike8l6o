class Solution {
    public int numDecodings(String s) {
        int next = 1;
        int nextNext = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = 0;

            if (s.charAt(i) != '0') {
                current = next;

                if (i + 1 < s.length()) {
                    int twoDigit = Integer.parseInt(s.substring(i, i + 2));

                    if (twoDigit >= 10 && twoDigit <= 26) {
                        current += nextNext;
                    }
                }
            }

            nextNext = next;
            next = current;
        }

        return next;
    }
}
