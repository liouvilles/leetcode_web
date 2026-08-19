class Solution {
    fun countBalls(lowLimit:Int,highLimit:Int):Int{
        val counts=IntArray(50);
        var answer=0;
        for(original in lowLimit..highLimit){
            var value=original;
            var sum=0;
            while(value>0){
                sum+=value%10;
                value/=10
            };
            counts[sum]++;
            answer=maxOf(answer,counts[sum])
        };
        return answer
    }
}
