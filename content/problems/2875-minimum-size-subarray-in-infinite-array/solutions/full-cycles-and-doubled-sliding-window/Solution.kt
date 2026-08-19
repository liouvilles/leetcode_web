class Solution {
    fun minSizeSubarray(nums:IntArray,target:Int):Int{
        val n=nums.size;
        val total=nums.sumOf{
            it.toLong()
        };
        val quotient=target.toLong()/total;
        val remainder=target.toLong()%total;
        if(remainder==0L)return (quotient*n).toInt();
        var left=0;
        var best=Int.MAX_VALUE;
        var window=0L;
        for(right in 0 until 2*n){
            window+=nums[right%n];
            while(window>remainder&&left<=right)window-=nums[left++%n];
            if(window==remainder)best=minOf(best,right-left+1)
        };
        return if(best==Int.MAX_VALUE)-1 else (quotient*n+best).toInt()
    }
}
