class Solution {
    fun maximumStrength(nums:IntArray,k:Int):Long{
        val n=nums.size
        val negative=Long.MIN_VALUE/4
        var previous=LongArray(n+1)
        for(part in 1..k){
            val current=LongArray(n+1){negative}
            val coefficient=(k-part+1).toLong()*(if(part%2==1)1 else -1)
            var bestEnding=negative
            for(position in part..n){
                val value=coefficient*nums[position-1]
                bestEnding=maxOf(bestEnding+value,previous[position-1]+value)
                current[position]=maxOf(current[position-1],bestEnding)
            }
            previous=current
        }
        return previous[n]
    }
}
