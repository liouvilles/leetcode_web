class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); StringBuilder answer = new StringBuilder();
        for (int index = words.length - 1; index >= 0; index--) { if (answer.length() > 0) answer.append(' '); answer.append(words[index]); }
        return answer.toString();
    }
}
