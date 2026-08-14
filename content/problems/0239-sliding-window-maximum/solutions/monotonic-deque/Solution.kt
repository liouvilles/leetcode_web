class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val answer = IntArray(nums.size - k + 1); val deque: ArrayDeque<Int> = ArrayDeque()
        for (right in nums.indices) { while (deque.isNotEmpty() && deque.first() <= right - k) deque.removeFirst(); while (deque.isNotEmpty() && nums[deque.last()] <= nums[right]) deque.removeLast(); deque.addLast(right); if (right >= k - 1) answer[right - k + 1] = nums[deque.first()] }
        return answer
    }
}
