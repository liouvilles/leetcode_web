class Solution {
    public int strStr(String haystack, String needle) {
        for (int start = 0; start + needle.length() <= haystack.length(); start++) {
            int index = 0;
            while (index < needle.length() && haystack.charAt(start + index) == needle.charAt(index)) index++;
            if (index == needle.length()) return start;
        }
        return -1;
    }
}
