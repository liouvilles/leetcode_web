class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val answer = ArrayList<List<Int>>()
        build(nums, 0, ArrayList(), answer)
        return answer
    }

    private fun build(nums: IntArray, start: Int, path: MutableList<Int>, answer: MutableList<List<Int>>) {
        answer.add(ArrayList(path))
        for (index in start until nums.size) {
            path.add(nums[index])
            build(nums, index + 1, path, answer)
            path.removeAt(path.lastIndex)
        }
    }
}
