class Solution {
    fun getMaximumConsecutive(coins:IntArray):Int{
        coins.sort();
        var reachable=0;
        for(coin in coins){
            if(coin>reachable+1)break;
            reachable+=coin
        };
        return reachable+1
    }
}
