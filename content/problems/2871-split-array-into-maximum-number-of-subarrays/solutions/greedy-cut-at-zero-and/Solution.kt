class Solution {
    fun maxSubarrays(nums:IntArray):Int{
        var current=-1;
        var answer=0;
        for(value in nums){
            current=current and value;
            if(current==0){
                answer++;
                current=-1
            }
        };
        return maxOf(answer,1)
    }
}
