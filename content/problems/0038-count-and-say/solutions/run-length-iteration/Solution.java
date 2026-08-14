class Solution {
    public String countAndSay(int n) {
        String answer = "1";
        for (int round = 1; round < n; round++) {
            StringBuilder next = new StringBuilder();
            for (int start = 0; start < answer.length();) { int end = start + 1; while (end < answer.length() && answer.charAt(end) == answer.charAt(start)) end++; next.append(end - start).append(answer.charAt(start)); start = end; }
            answer = next.toString();
        }
        return answer;
    }
}
