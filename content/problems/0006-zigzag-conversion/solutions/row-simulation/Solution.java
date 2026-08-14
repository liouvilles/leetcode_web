class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;
        List<StringBuilder> rows = new ArrayList<>(); for (int row = 0; row < numRows; row++) rows.add(new StringBuilder());
        int row = 0, step = 1;
        for (char value : s.toCharArray()) { rows.get(row).append(value); if (row == 0) step = 1; else if (row == numRows - 1) step = -1; row += step; }
        StringBuilder answer = new StringBuilder(); for (StringBuilder value : rows) answer.append(value); return answer.toString();
    }
}
