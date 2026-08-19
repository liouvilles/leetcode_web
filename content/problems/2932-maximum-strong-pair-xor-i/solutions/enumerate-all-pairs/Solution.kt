class Solution {
    fun maximumStrongPairXor(nums:IntArray):Int{
        var answer=0;
        for(i in nums.indices)for(j in i until nums.size)if(kotlin.math.abs(nums[i]-nums[j])<=minOf(nums[i],nums[j]))answer=maxOf(answer,nums[i] xor nums[j]);
        return answer
    }
}
