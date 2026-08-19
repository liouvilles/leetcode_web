class Solution {
    fun arrayPairSum(nums:IntArray):Int{
        nums.sort();
        var answer=0;
        for(i in nums.indices step 2)answer+=nums[i];
        return answer
    }
}
