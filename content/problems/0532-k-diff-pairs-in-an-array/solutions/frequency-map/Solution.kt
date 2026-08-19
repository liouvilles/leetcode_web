class Solution {
    fun findPairs(nums:IntArray,k:Int):Int{
        if(k<0)return 0;
        val counts=nums.toList().groupingBy{
            it
        }.eachCount();
        return counts.count{
            (value,count)->if(k==0)count>1 else counts.containsKey(value+k)
        }
    }
}
