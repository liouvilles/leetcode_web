class Solution {
    fun putMarbles(weights:IntArray,k:Int):Long{
        val boundaries=IntArray(weights.size-1){
            weights[it]+weights[it+1]
        };
        boundaries.sort();
        var answer=0L;
        for(i in 0 until k-1)answer+=boundaries[boundaries.lastIndex-i].toLong()-boundaries[i];
        return answer
    }
}
