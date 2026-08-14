class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        build(n, 0, 0, new StringBuilder(), answer);
        return answer;
    }

    private void build(int n, int open, int close, StringBuilder path, List<String> answer) {
        if (path.length() == 2 * n) {
            answer.add(path.toString());
            return;
        }
        if (open < n) {
            path.append('(');
            build(n, open + 1, close, path, answer);
            path.setLength(path.length() - 1);
        }
        if (close < open) {
            path.append(')');
            build(n, open, close + 1, path, answer);
            path.setLength(path.length() - 1);
        }
    }
}
