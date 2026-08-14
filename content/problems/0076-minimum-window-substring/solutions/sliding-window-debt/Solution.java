class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int[] need = new int[128];
        for (int index = 0; index < t.length(); index++) need[t.charAt(index)]++;
        int missing = t.length(), left = 0, bestStart = 0, bestLength = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            char added = s.charAt(right);
            if (need[added] > 0) missing--;
            need[added]--;
            while (missing == 0) {
                int length = right - left + 1;
                if (length < bestLength) { bestLength = length; bestStart = left; }
                char removed = s.charAt(left++);
                need[removed]++;
                if (need[removed] > 0) missing++;
            }
        }
        return bestLength == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLength);
    }
}
