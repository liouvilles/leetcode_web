class Solution {
    fun minimumLines(stockPrices:Array<IntArray>):Int{
        stockPrices.sortBy{
            it[0]
        };
        if(stockPrices.size==1)return 0;
        var answer=1;
        for(i in 2 until stockPrices.size){
            val dy1=stockPrices[i-1][1].toLong()-stockPrices[i-2][1];
            val dx1=stockPrices[i-1][0].toLong()-stockPrices[i-2][0];
            val dy2=stockPrices[i][1].toLong()-stockPrices[i-1][1];
            val dx2=stockPrices[i][0].toLong()-stockPrices[i-1][0];
            if(dy1*dx2!=dy2*dx1)answer++
        };
        return answer
    }
}
