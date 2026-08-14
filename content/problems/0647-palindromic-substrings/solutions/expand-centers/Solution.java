class Solution {
    public int countSubstrings(String s) {
        int answer = 0; for (int center = 0; center < s.length(); center++) answer += expand(s, center, center) + expand(s, center, center + 1); return answer;
    }
    private int expand(String s, int left, int right) { int count = 0; while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) count++; return count; }
}
