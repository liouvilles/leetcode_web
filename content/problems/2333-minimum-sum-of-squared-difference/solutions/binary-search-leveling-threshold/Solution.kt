class Solution {
    fun minSumSquareDiff(nums1:IntArray,nums2:IntArray,k1:Int,k2:Int):Long{
        val diff=IntArray(nums1.size);
        var high=0;
        var total=0L;
        for(i in nums1.indices){
            diff[i]=kotlin.math.abs(nums1[i]-nums2[i]);
            high=maxOf(high,diff[i]);
            total+=diff[i]
        };
        val operations=minOf(total,k1.toLong()+k2);
        var low=0;
        while(low<high){
            val middle=(low+high)/2;
            var needed=0L;
            for(value in diff)if(value>middle)needed+=value-middle;
            if(needed<=operations)high=middle else low=middle+1
        };
        val threshold=low;
        var used=0L;
        for(value in diff)if(value>threshold)used+=value-threshold;
        var remaining=operations-used;
        var answer=0L;
        for(value in diff){
            var reduced=minOf(value,threshold);
            if(reduced==threshold&&reduced>0&&remaining>0){
                reduced--;
                remaining--
            };
            answer+=reduced.toLong()*reduced
        };
        return answer
    }
}
