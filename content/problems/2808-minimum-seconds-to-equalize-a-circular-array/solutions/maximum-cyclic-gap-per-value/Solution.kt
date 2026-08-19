class Solution {
    fun minimumSeconds(nums:List<Int>):Int{
        val positions=HashMap<Int,MutableList<Int>>();
        for(i in nums.indices)positions.getOrPut(nums[i]){
            mutableListOf()
        }.add(i);
        var answer=nums.size;
        for(list in positions.values){
            var maximumGap=list.first()+nums.size-list.last();
            for(i in 1 until list.size)maximumGap=maxOf(maximumGap,list[i]-list[i-1]);
            answer=minOf(answer,maximumGap/2)
        };
        return answer
    }
}
