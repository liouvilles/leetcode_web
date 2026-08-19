class Solution {
    fun summaryRanges(nums:IntArray):List<String>{
        val answer=mutableListOf<String>();
        var start=0;
        while(start<nums.size){
            var end=start;
            while(end+1<nums.size&&nums[end+1].toLong()-nums[end]==1L)end++;
            answer.add(if(start==end)nums[start].toString() else "${nums[start]}->${nums[end]}");
            start=end+1
        };
        return answer
    }
}
