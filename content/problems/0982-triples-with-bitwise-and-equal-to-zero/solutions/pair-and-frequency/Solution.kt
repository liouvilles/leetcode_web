class Solution {
    fun countTriplets(nums:IntArray):Int{
        val frequency=mutableMapOf<Int,Int>();
        for(a in nums)for(b in nums)frequency[a and b]=(frequency[a and b]?:0)+1;
        var answer=0;
        for(value in nums)for((mask,count) in frequency)if(mask and value==0)answer+=count;
        return answer
    }
}
