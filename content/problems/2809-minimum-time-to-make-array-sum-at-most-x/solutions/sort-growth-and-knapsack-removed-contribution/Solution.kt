class Solution {
    fun minimumTime(nums1:List<Int>,nums2:List<Int>,x:Int):Int{
        val n=nums1.size;
        val pairs=Array(n){
            i->intArrayOf(nums1[i],nums2[i])
        };
        pairs.sortWith(Comparator{
            a,b->a[1].compareTo(b[1])
        });
        var base=0L;
        var growth=0L;
        for(pair in pairs){
            base+=pair[0];
            growth+=pair[1]
        };
        val dp=LongArray(n+1);
        for(i in pairs.indices)for(selected in i+1 downTo 1)dp[selected]=maxOf(dp[selected],dp[selected-1]+pairs[i][0]+pairs[i][1].toLong()*selected);
        for(seconds in 0..n)if(base+growth*seconds-dp[seconds]<=x)return seconds;
        return -1
    }
}
