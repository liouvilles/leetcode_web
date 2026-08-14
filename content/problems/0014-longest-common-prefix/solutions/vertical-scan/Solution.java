class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        for (int index = 0; index < first.length(); index++) for (int item = 1; item < strs.length; item++) if (index == strs[item].length() || strs[item].charAt(index) != first.charAt(index)) return first.substring(0, index);
        return first;
    }
}
