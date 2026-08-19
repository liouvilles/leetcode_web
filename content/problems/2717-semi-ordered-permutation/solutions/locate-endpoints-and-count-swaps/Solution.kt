class Solution {
    fun semiOrderedPermutation(nums:IntArray):Int{
        var posOne=0;
        var posMax=0;
        for(i in nums.indices){
            if(nums[i]==1)posOne=i;
            if(nums[i]==nums.size)posMax=i
        };
        return posOne+nums.lastIndex-posMax-if(posOne>posMax)1 else 0
    }
}
