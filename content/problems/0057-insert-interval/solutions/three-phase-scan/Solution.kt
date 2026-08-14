class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val answer = mutableListOf<IntArray>(); var index = 0
        while (index < intervals.size && intervals[index][1] < newInterval[0]) answer.add(intervals[index++])
        while (index < intervals.size && intervals[index][0] <= newInterval[1]) { newInterval[0] = minOf(newInterval[0], intervals[index][0]); newInterval[1] = maxOf(newInterval[1], intervals[index++][1]) }
        answer.add(newInterval); while (index < intervals.size) answer.add(intervals[index++])
        return answer.toTypedArray()
    }
}
