class Solution {
    fun maxProfit(k:Int,prices:IntArray):Int{
        if(k>=prices.size/2){
            var p=0;
            for(i in 1 until prices.size)p+=maxOf(0,prices[i]-prices[i-1]);
            return p
        };
        val buy=IntArray(k+1){
            Int.MIN_VALUE/2
        };
        val sell=IntArray(k+1);
        for(price in prices)for(t in 1..k){
            buy[t]=maxOf(buy[t],sell[t-1]-price);
            sell[t]=maxOf(sell[t],buy[t]+price)
        };
        return sell[k]
    }
}
