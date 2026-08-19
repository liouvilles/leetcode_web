class Solution {
    fun minSubsequence(nums:IntArray):List<Int>{
        nums.sort();
        val total=nums.sum();
        var selected=0;
        val answer=mutableListOf<Int>();
        for(i in nums.lastIndex downTo 0){
            answer.add(nums[i]);
            selected+=nums[i];
            if(selected>total-selected)break
        };
        return answer
    }
}
