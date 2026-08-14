class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue: ArrayDeque<IntArray> = ArrayDeque(); var fresh = 0
        for (row in grid.indices) for (column in grid[0].indices) if (grid[row][column] == 2) queue.add(intArrayOf(row, column)) else if (grid[row][column] == 1) fresh++
        val directions = arrayOf(intArrayOf(1,0), intArrayOf(-1,0), intArrayOf(0,1), intArrayOf(0,-1)); var minutes = 0
        while (fresh > 0 && queue.isNotEmpty()) { repeat(queue.size) { val cell = queue.removeFirst(); for (direction in directions) { val row = cell[0] + direction[0]; val column = cell[1] + direction[1]; if (row in grid.indices && column in grid[0].indices && grid[row][column] == 1) { grid[row][column] = 2; fresh--; queue.add(intArrayOf(row, column)) } } }; minutes++ }
        return if (fresh == 0) minutes else -1
    }
}
