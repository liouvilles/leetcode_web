class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1 || numRows >= s.length) return s
        val rows = List(numRows) { StringBuilder() }; var row = 0; var step = 1
        for (value in s) { rows[row].append(value); if (row == 0) step = 1 else if (row == numRows - 1) step = -1; row += step }
        return rows.joinToString("")
    }
}
