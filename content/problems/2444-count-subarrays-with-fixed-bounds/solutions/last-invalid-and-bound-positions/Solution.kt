class Solution {
    fun countSubarrays(nums:IntArray,minK:Int,maxK:Int):Long{
        var bad=-1;
        var lastMin=-1;
        var lastMax=-1;
        var answer=0L;
        for(i in nums.indices){
            if(nums[i]<minK||nums[i]>maxK)bad=i;
            if(nums[i]==minK)lastMin=i;
            if(nums[i]==maxK)lastMax=i;
            answer+=maxOf(0,minOf(lastMin,lastMax)-bad)
        };
        return answer
    }
}
