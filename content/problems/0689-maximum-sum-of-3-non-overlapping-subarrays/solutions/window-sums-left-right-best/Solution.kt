class Solution {
    fun maxSumOfThreeSubarrays(nums:IntArray,k:Int):IntArray{
        val count=nums.size-k+1;
        val sums=IntArray(count);
        var window=0;
        for(i in nums.indices){
            window+=nums[i];
            if(i>=k)window-=nums[i-k];
            if(i>=k-1)sums[i-k+1]=window
        };
        val left=IntArray(count);
        val right=IntArray(count);
        var best=0;
        for(i in 0 until count){
            if(sums[i]>sums[best])best=i;
            left[i]=best
        };
        best=count-1;
        for(i in count-1 downTo 0){
            if(sums[i]>=sums[best])best=i;
            right[i]=best
        };
        var answer=IntArray(3);
        var maximum=-1;
        for(middle in k..count-k-1){
            val first=left[middle-k];
            val third=right[middle+k];
            val total=sums[first]+sums[middle]+sums[third];
            if(total>maximum){
                maximum=total;
                answer=intArrayOf(first,middle,third)
            }
        };
        return answer
    }
}
