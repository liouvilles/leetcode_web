class Solution {
    fun numOfPairs(nums:Array<String>,target:String):Int{
        val frequency=nums.groupingBy{
            it
        }.eachCount();
        var answer=0;
        for(split in 1 until target.length){
            val left=target.substring(0,split);
            val right=target.substring(split);
            val first=frequency[left]?:0;
            val second=frequency[right]?:0;
            answer+=if(left==right)first*(first-1) else first*second
        };
        return answer
    }
}
