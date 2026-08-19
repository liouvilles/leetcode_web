class Solution {
    fun findMaxAverage(nums:IntArray,k:Int):Double{
        var window=0L;
        for(i in 0 until k)window+=nums[i];
        var best=window;
        for(right in k until nums.size){
            window+=nums[right]-nums[right-k];
            best=maxOf(best,window)
        };
        return best.toDouble()/k
    }
}
