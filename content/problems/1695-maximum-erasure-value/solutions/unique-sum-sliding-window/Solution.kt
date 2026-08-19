class Solution {
    fun maximumUniqueSubarray(nums:IntArray):Int{
        val seen=mutableSetOf<Int>();
        var left=0;
        var sum=0;
        var answer=0;
        for(value in nums){
            while(value in seen){
                seen.remove(nums[left]);
                sum-=nums[left++]
            };
            seen.add(value);
            sum+=value;
            answer=maxOf(answer,sum)
        };
        return answer
    }
}
