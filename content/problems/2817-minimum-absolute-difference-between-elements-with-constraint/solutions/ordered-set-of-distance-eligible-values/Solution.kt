class Solution {
    fun minAbsoluteDifference(nums:List<Int>,x:Int):Int{
        val values=java.util.TreeSet<Int>();
        var answer=Int.MAX_VALUE;
        for(right in x until nums.size){
            val value=nums[right];
            values.add(nums[right-x]);
            values.floor(value)?.let{
                answer=minOf(answer,value-it)
            };
            values.ceiling(value)?.let{
                answer=minOf(answer,it-value)
            }
        };
        return answer
    }
}
