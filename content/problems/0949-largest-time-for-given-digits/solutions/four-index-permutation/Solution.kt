class Solution {
    fun largestTimeFromDigits(arr:IntArray):String{
        var best=-1;
        for(i in 0..3)for(j in 0..3)if(j!=i)for(k in 0..3)if(k!=i&&k!=j)for(l in 0..3)if(l!=i&&l!=j&&l!=k){
            val hour=10*arr[i]+arr[j];
            val minute=10*arr[k]+arr[l];
            if(hour<24&&minute<60)best=maxOf(best,hour*60+minute)
        };
        return if(best<0)"" else java.lang.String.format("%02d:%02d",best/60,best%60)
    }
}
