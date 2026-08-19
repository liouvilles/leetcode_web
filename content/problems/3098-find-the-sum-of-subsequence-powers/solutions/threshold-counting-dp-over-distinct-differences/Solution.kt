class Solution {
    private val mod=1000000007L
    private fun countAtLeast(nums:IntArray,k:Int,difference:Int):Long{
        val n=nums.size
        var previous=LongArray(n){1L}
        for(length in 2..k){
            val prefix=LongArray(n)
            val current=LongArray(n)
            var sum=0L
            for(index in 0 until n){sum=(sum+previous[index])%mod;prefix[index]=sum}
            var pointer=-1
            for(index in 0 until n){
                while(pointer+1<index&&nums[index].toLong()-nums[pointer+1]>=difference)pointer++
                if(pointer>=0)current[index]=prefix[pointer]
            }
            previous=current
        }
        var result=0L
        for(count in previous)result=(result+count)%mod
        return result
    }
    fun sumOfPowers(nums:IntArray,k:Int):Int{
        nums.sort()
        val set=java.util.TreeSet<Int>()
        for(left in nums.indices)for(right in left+1 until nums.size)if(nums[right]>nums[left])set.add(nums[right]-nums[left])
        val differences=set.toList()
        val counts=LongArray(differences.size){countAtLeast(nums,k,differences[it])}
        var answer=0L
        for(index in differences.indices){
            val next=if(index+1<counts.size)counts[index+1] else 0L
            val exact=(counts[index]-next+mod)%mod
            answer=(answer+differences[index].toLong()%mod*exact)%mod
        }
        return answer.toInt()
    }
}
