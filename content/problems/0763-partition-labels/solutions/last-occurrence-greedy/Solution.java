class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26]; for (int index = 0; index < s.length(); index++) last[s.charAt(index) - 'a'] = index;
        List<Integer> answer = new ArrayList<>(); int start = 0, end = 0;
        for (int index = 0; index < s.length(); index++) { end = Math.max(end, last[s.charAt(index) - 'a']); if (index == end) { answer.add(end - start + 1); start = index + 1; } }
        return answer;
    }
}
