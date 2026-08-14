class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] possible = new boolean[s.length() + 1];
        possible[0] = true;
        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (possible[start] && words.contains(s.substring(start, end))) {
                    possible[end] = true;
                    break;
                }
            }
        }
        return possible[s.length()];
    }
}
