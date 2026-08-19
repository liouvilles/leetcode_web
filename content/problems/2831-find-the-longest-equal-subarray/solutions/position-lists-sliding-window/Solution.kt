class Solution {
    fun longestEqualSubarray(nums:List<Int>,k:Int):Int{
        val positions=HashMap<Int,MutableList<Int>>();
        for(i in nums.indices)positions.getOrPut(nums[i]){
            mutableListOf()
        }.add(i);
        var answer=0;
        for(list in positions.values){
            var left=0;
            for(right in list.indices){
                while(list[right]-list[left]-(right-left)>k)left++;
                answer=maxOf(answer,right-left+1)
            }
        };
        return answer
    }
}
