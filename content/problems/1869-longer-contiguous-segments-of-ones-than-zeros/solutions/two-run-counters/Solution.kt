class Solution {
    fun checkZeroOnes(s:String):Boolean{
        var ones=0;
        var zeros=0;
        var bestOne=0;
        var bestZero=0;
        for(value in s)if(value=='1'){
            ones++;
            zeros=0;
            bestOne=maxOf(bestOne,ones)
        }else{
            zeros++;
            ones=0;
            bestZero=maxOf(bestZero,zeros)
        };
        return bestOne>bestZero
    }
}
