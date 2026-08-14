class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] target = new int[26], window = new int[26];
        for (int index = 0; index < s1.length(); index++) { target[s1.charAt(index) - 'a']++; window[s2.charAt(index) - 'a']++; }
        for (int left = 0; left <= s2.length() - s1.length(); left++) { if (Arrays.equals(target, window)) return true; int next = left + s1.length(); if (next < s2.length()) { window[s2.charAt(left) - 'a']--; window[s2.charAt(next) - 'a']++; } }
        return false;
    }
}
