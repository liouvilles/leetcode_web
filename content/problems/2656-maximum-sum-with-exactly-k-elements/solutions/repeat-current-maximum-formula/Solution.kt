class Solution {
    fun maximizeSum(nums:IntArray,k:Int):Int{
        val maximum=nums.maxOrNull()!!;
        return k*maximum+k*(k-1)/2
    }
}
