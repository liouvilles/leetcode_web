class Solution {
    fun generate(numRows: Int): List<List<Int>> { val answer = mutableListOf<List<Int>>(); for (row in 0 until numRows) { val current = MutableList(row + 1) { 1 }; for (column in 1 until row) current[column] = answer[row - 1][column - 1] + answer[row - 1][column]; answer.add(current) }; return answer }
}
