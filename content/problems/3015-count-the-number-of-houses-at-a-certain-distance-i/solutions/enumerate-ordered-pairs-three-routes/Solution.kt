class Solution {
    fun countOfPairs(n:Int,x:Int,y:Int):IntArray{
        val answer=IntArray(n);
        for(first in 1..n)for(second in 1..n)if(first!=second){
            val distance=minOf(kotlin.math.abs(first-second),kotlin.math.abs(first-x)+1+kotlin.math.abs(y-second),kotlin.math.abs(first-y)+1+kotlin.math.abs(x-second));
            answer[distance-1]++
        };
        return answer
    }
}
