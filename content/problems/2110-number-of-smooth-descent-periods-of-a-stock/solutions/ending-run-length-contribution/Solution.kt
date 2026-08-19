class Solution {
    fun getDescentPeriods(prices:IntArray):Long{
        var answer=1L;
        var run=1L;
        for(i in 1 until prices.size){
            run=if(prices[i]==prices[i-1]-1)run+1 else 1;
            answer+=run
        };
        return answer
    }
}
