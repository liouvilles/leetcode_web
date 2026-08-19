class Solution {
    fun sumOfBeauties(nums:IntArray):Int{
        val n=nums.size;
        val left=IntArray(n);
        val right=IntArray(n);
        left[0]=nums[0];
        for(i in 1 until n)left[i]=maxOf(left[i-1],nums[i]);
        right[n-1]=nums[n-1];
        for(i in n-2 downTo 0)right[i]=minOf(right[i+1],nums[i]);
        var answer=0;
        for(i in 1 until n-1)if(nums[i]>left[i-1]&&nums[i]<right[i+1])answer+=2 else if(nums[i]>nums[i-1]&&nums[i]<nums[i+1])answer++;
        return answer
    }
}
