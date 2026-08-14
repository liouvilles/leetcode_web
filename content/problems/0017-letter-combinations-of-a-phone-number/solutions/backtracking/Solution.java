class Solution {
    private static final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits.isEmpty()) return answer;
        build(digits, 0, new StringBuilder(), answer);
        return answer;
    }

    private void build(String digits, int index, StringBuilder path, List<String> answer) {
        if (index == digits.length()) { answer.add(path.toString()); return; }
        String letters = LETTERS[digits.charAt(index) - '0'];
        for (int offset = 0; offset < letters.length(); offset++) {
            path.append(letters.charAt(offset));
            build(digits, index + 1, path, answer);
            path.setLength(path.length() - 1);
        }
    }
}
