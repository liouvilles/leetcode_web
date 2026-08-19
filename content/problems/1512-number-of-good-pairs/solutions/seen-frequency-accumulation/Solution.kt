class Solution {
    fun numIdenticalPairs(nums:IntArray):Int{
        val count=mutableMapOf<Int,Int>();
        var answer=0;
        for(value in nums){
            answer+=count[value]?:0;
            count[value]=(count[value]?:0)+1
        };
        return answer
    }
}
