class Solution {
    fun countExcellentPairs(nums:IntArray,k:Int):Long{
        val unique=nums.toHashSet();
        val frequency=LongArray(31);
        for(value in unique)frequency[Integer.bitCount(value)]++;
        var answer=0L;
        for(i in 0 until 31)for(j in 0 until 31)if(i+j>=k)answer+=frequency[i]*frequency[j];
        return answer
    }
}
