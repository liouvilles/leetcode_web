class Solution {
    public String convertToTitle(int columnNumber) { StringBuilder answer = new StringBuilder(); while (columnNumber > 0) { columnNumber--; answer.append((char)('A' + columnNumber % 26)); columnNumber /= 26; } return answer.reverse().toString(); }
}
