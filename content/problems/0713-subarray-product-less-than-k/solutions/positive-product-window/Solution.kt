class Solution {
    fun numSubarrayProductLessThanK(nums:IntArray,k:Int):Int{
        if(k<=1)return 0;
        var product=1L;
        var left=0;
        var answer=0;
        for(right in nums.indices){
            product*=nums[right];
            while(product>=k)product/=nums[left++];
            answer+=right-left+1
        };
        return answer
    }
}
