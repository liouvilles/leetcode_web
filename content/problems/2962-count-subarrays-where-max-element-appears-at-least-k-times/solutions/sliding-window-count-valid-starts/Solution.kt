class Solution {
    fun countSubarrays(nums:IntArray,k:Int):Long{
        val maximum=nums.maxOrNull()!!;
        var left=0;
        var count=0;
        var answer=0L;
        for(value in nums){
            if(value==maximum)count++;
            while(count>=k)if(nums[left++]==maximum)count--;
            answer+=left
        };
        return answer
    }
}
