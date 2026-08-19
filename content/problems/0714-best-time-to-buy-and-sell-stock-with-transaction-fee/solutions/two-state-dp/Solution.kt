class Solution {
    fun maxProfit(prices:IntArray,fee:Int):Int{
        var cash=0;
        var hold=-prices[0];
        for(i in 1 until prices.size){
            val oldCash=cash;
            cash=maxOf(cash,hold+prices[i]-fee);
            hold=maxOf(hold,oldCash-prices[i])
        };
        return cash
    }
}
