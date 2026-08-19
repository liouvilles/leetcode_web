class Solution {
    fun countAlternatingSubarrays(nums:IntArray):Long{
        var answer=1L;
        var ending=1L;
        for(index in 1 until nums.size){
            ending=if(nums[index]!=nums[index-1])ending+1 else 1;
            answer+=ending
        };
        return answer
    }
}
