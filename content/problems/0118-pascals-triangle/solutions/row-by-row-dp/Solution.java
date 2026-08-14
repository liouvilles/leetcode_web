class Solution {
    public List<List<Integer>> generate(int numRows) { List<List<Integer>> answer = new ArrayList<>(); for (int row = 0; row < numRows; row++) { List<Integer> current = new ArrayList<>(); for (int column = 0; column <= row; column++) current.add(column == 0 || column == row ? 1 : answer.get(row - 1).get(column - 1) + answer.get(row - 1).get(column)); answer.add(current); } return answer; }
}
