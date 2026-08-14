class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val counts = linkedMapOf<Int, Int>(); for (value in nums) counts[value] = (counts[value] ?: 0) + 1
        val buckets = List(nums.size + 1) { ArrayList<Int>() }; for ((value, frequency) in counts) buckets[frequency].add(value)
        val answer = IntArray(k); var index = 0
        for (frequency in nums.size downTo 1) for (value in buckets[frequency]) { if (index < k) answer[index++] = value }
        return answer
    }
}
