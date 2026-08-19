class Solution {
    fun minimumOperations(nums:IntArray):Int{
        return nums.filter{
            it>0
        }.toSet().size
    }
}
