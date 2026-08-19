class Solution {
    fun countBadPairs(nums:IntArray):Long{
        val frequency=HashMap<Int,Int>();
        var answer=0L;
        for(index in nums.indices){
            val key=nums[index]-index;
            answer+=index-(frequency[key]?:0);
            frequency[key]=(frequency[key]?:0)+1
        };
        return answer
    }
}
