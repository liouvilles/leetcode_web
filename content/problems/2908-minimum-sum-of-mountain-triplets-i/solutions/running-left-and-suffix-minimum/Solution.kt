class Solution {
    fun minimumSum(nums:IntArray):Int{
        val n=nums.size;
        val rightMinimum=IntArray(n);
        rightMinimum[n-1]=nums[n-1];
        for(i in n-2 downTo 0)rightMinimum[i]=minOf(nums[i],rightMinimum[i+1]);
        var leftMinimum=nums[0];
        var answer=Int.MAX_VALUE;
        for(j in 1 until n-1){
            if(leftMinimum<nums[j]&&rightMinimum[j+1]<nums[j])answer=minOf(answer,leftMinimum+nums[j]+rightMinimum[j+1]);
            leftMinimum=minOf(leftMinimum,nums[j])
        };
        return if(answer==Int.MAX_VALUE)-1 else answer
    }
}
