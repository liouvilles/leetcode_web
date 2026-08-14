class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val answer = ArrayList<List<Int>>()
        build(nums, BooleanArray(nums.size), ArrayList(), answer)
        return answer
    }

    private fun build(nums: IntArray, used: BooleanArray, path: MutableList<Int>, answer: MutableList<List<Int>>) {
        if (path.size == nums.size) {
            answer.add(ArrayList(path))
            return
        }
        for (index in nums.indices) {
            if (used[index]) continue
            used[index] = true
            path.add(nums[index])
            build(nums, used, path, answer)
            path.removeAt(path.lastIndex)
            used[index] = false
        }
    }
}
