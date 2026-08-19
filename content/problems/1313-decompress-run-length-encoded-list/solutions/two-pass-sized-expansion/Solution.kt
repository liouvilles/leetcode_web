class Solution {
    fun decompressRLElist(nums:IntArray):IntArray{
        var length=0;
        for(i in nums.indices step 2)length+=nums[i];
        val answer=IntArray(length);
        var write=0;
        for(i in nums.indices step 2)repeat(nums[i]){
            answer[write++]=nums[i+1]
        };
        return answer
    }
}
