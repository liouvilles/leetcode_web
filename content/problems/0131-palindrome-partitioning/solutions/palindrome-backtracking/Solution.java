class Solution {
    public List<List<String>> partition(String s) { List<List<String>> answer = new ArrayList<>(); backtrack(s, 0, new ArrayList<>(), answer); return answer; }
    private void backtrack(String s, int start, List<String> path, List<List<String>> answer) { if (start == s.length()) { answer.add(new ArrayList<>(path)); return; } for (int end = start; end < s.length(); end++) if (isPalindrome(s, start, end)) { path.add(s.substring(start, end + 1)); backtrack(s, end + 1, path, answer); path.remove(path.size() - 1); } }
    private boolean isPalindrome(String s, int left, int right) { while (left < right) if (s.charAt(left++) != s.charAt(right--)) return false; return true; }
}
