class Solution {
    fun sumOfUnique(nums:IntArray):Int=nums.toList().groupingBy{
        it
    }.eachCount().filterValues{
        it==1
    }.keys.sum()
}
