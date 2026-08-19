class Solution {
    fun minimumSubarrayLength(nums:IntArray,k:Int):Int{
        val bitCount=IntArray(31);
        var left=0;
        var currentOr=0;
        var answer=nums.size+1;
        for(right in nums.indices){
            for(bit in 0 until 31)if(nums[right] and (1 shl bit)!=0){
                bitCount[bit]++;
                currentOr=currentOr or (1 shl bit)
            };
            while(left<=right&&currentOr>=k){
                answer=minOf(answer,right-left+1);
                for(bit in 0 until 31)if(nums[left] and (1 shl bit)!=0&&--bitCount[bit]==0)currentOr=currentOr and (1 shl bit).inv();
                left++
            }
        };
        return if(answer==nums.size+1)-1 else answer
    }
}
