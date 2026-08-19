class Solution {
    fun heightChecker(heights:IntArray):Int{
        val expected=heights.sortedArray();
        return heights.indices.count{
            heights[it]!=expected[it]
        }
    }
}
