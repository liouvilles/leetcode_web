class Solution {
    public List<String> restoreIpAddresses(String s) { List<String> answer = new ArrayList<>(); backtrack(s, 0, new ArrayList<>(), answer); return answer; }
    private void backtrack(String s, int index, List<String> parts, List<String> answer) {
        int remainingParts = 4 - parts.size(), remainingChars = s.length() - index; if (remainingChars < remainingParts || remainingChars > remainingParts * 3) return;
        if (parts.size() == 4) { if (index == s.length()) answer.add(String.join(".", parts)); return; }
        int value = 0; for (int end = index; end < Math.min(index + 3, s.length()); end++) { if (end > index && s.charAt(index) == '0') break; value = value * 10 + s.charAt(end) - '0'; if (value > 255) break; parts.add(s.substring(index, end + 1)); backtrack(s, end + 1, parts, answer); parts.remove(parts.size() - 1); }
    }
}
