class Solution {
    fun check(nums:IntArray):Boolean=nums.indices.count{
        nums[it]>nums[(it+1)%nums.size]
    }<=1
}
