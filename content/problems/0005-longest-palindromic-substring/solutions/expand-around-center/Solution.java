class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        for (int center = 0; center < s.length(); center++) {
            int length = Math.max(expand(s, center, center), expand(s, center, center + 1));
            if (length > right - left + 1) {
                left = center - (length - 1) / 2;
                right = center + length / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
