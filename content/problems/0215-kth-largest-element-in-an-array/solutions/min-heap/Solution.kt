class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = java.util.PriorityQueue<Int>()
        for (num in nums) {
            heap.offer(num)
            if (heap.size > k) heap.poll()
        }
        return heap.peek()
    }
}
