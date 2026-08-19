class Solution {
    fun countQuadruplets(nums:IntArray):Long{
        val less=IntArray(nums.size);
        var answer=0L;
        for(j in nums.indices){
            var greater=0;
            for(k in nums.lastIndex downTo j+1){
                if(nums[k]>nums[j])greater++ else answer+=less[k].toLong()*greater
            };
            for(k in j+1 until nums.size)if(nums[j]<nums[k])less[k]++
        };
        return answer
    }
}
