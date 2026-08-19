class Solution {
    fun minDistance(houses:IntArray,k:Int):Int{
        houses.sort();
        val n=houses.size;
        val segment=Array(n){
            IntArray(n)
        };
        for(left in 0 until n)for(right in left until n){
            val median=houses[(left+right)/2];
            for(i in left..right)segment[left][right]+=kotlin.math.abs(houses[i]-median)
        };
        val inf=1_000_000_000;
        val dp=Array(k+1){
            IntArray(n+1){
                inf
            }
        };
        dp[0][0]=0;
        for(boxes in 1..k)for(count in 1..n)for(previous in 0 until count)if(dp[boxes-1][previous]<inf)dp[boxes][count]=minOf(dp[boxes][count],dp[boxes-1][previous]+segment[previous][count-1]);
        return dp[k][n]
    }
}
