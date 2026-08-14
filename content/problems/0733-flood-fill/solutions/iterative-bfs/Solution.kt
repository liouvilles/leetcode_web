class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val original = image[sr][sc]
        if (original == color) return image
        val directions = intArrayOf(1, 0, -1, 0, 1)
        val queue = java.util.ArrayDeque<IntArray>()
        queue.offer(intArrayOf(sr, sc))
        image[sr][sc] = color
        while (queue.isNotEmpty()) {
            val cell = queue.poll()
            for (d in 0 until 4) {
                val row = cell[0] + directions[d]
                val col = cell[1] + directions[d + 1]
                if (row in image.indices && col in image[0].indices && image[row][col] == original) {
                    image[row][col] = color
                    queue.offer(intArrayOf(row, col))
                }
            }
        }
        return image
    }
}
