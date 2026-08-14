class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(compareBy<IntArray> { it[0] })
        val merged = ArrayList<IntArray>()
        for (interval in intervals) {
            if (merged.isEmpty() || interval[0] > merged.last()[1]) {
                merged.add(intArrayOf(interval[0], interval[1]))
            } else {
                merged.last()[1] = maxOf(merged.last()[1], interval[1])
            }
        }
        return merged.toTypedArray()
    }
}
