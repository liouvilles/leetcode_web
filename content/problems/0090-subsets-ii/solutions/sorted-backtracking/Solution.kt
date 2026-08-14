class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> { nums.sort(); val answer = mutableListOf<List<Int>>(); val path = mutableListOf<Int>(); fun backtrack(start: Int) { answer.add(path.toList()); for (index in start until nums.size) { if (index > start && nums[index] == nums[index - 1]) continue; path.add(nums[index]); backtrack(index + 1); path.removeAt(path.lastIndex) } }; backtrack(0); return answer }
}
