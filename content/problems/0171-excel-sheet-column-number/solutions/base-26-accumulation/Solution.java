class Solution {
    public int titleToNumber(String columnTitle) { int answer = 0; for (char value : columnTitle.toCharArray()) answer = answer * 26 + value - 'A' + 1; return answer; }
}
