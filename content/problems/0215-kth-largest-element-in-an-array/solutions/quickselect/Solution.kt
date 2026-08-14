class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val target = nums.size - k
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val pivot = partition(nums, left, right)
            when {
                pivot == target -> return nums[pivot]
                pivot < target -> left = pivot + 1
                else -> right = pivot - 1
            }
        }
        error("unreachable")
    }

    private fun partition(a: IntArray, left: Int, right: Int): Int {
        val pick = kotlin.random.Random.nextInt(left, right + 1)
        a[pick] = a[right].also { a[right] = a[pick] }
        var store = left
        for (i in left until right) {
            if (a[i] < a[right]) a[store] = a[i].also { a[i] = a[store++] }
        }
        a[store] = a[right].also { a[right] = a[store] }
        return store
    }
}
