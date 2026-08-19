class Solution {
    fun maxScore(cardPoints:IntArray,k:Int):Int{
        val total=cardPoints.sum();
        val length=cardPoints.size-k;
        if(length==0)return total;
        var window=cardPoints.take(length).sum();
        var minimum=window;
        for(right in length until cardPoints.size){
            window+=cardPoints[right]-cardPoints[right-length];
            minimum=minOf(minimum,window)
        };
        return total-minimum
    }
}
