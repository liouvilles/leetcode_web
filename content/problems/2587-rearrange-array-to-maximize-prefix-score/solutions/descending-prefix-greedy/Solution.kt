class Solution {
    fun maxScore(nums:IntArray):Int{
        nums.sort();
        var sum=0L;
        var answer=0;
        for(i in nums.indices.reversed()){
            sum+=nums[i];
            if(sum<=0)break;
            answer++
        };
        return answer
    }
}
