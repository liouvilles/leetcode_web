class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val original = image[sr][sc]
        if (original == color) return image
        fun fill(row: Int, col: Int) {
            if (row !in image.indices || col !in image[0].indices || image[row][col] != original) return
            image[row][col] = color
            fill(row + 1, col); fill(row - 1, col)
            fill(row, col + 1); fill(row, col - 1)
        }
        fill(sr, sc)
        return image
    }
}
