class Solution {
    fun minDominoRotations(tops:IntArray,bottoms:IntArray):Int{
        fun check(target:Int):Int{
            var top=0;
            var bottom=0;
            for(i in tops.indices){
                if(tops[i]!=target&&bottoms[i]!=target)return Int.MAX_VALUE;
                if(tops[i]!=target)top++;
                if(bottoms[i]!=target)bottom++
            };
            return minOf(top,bottom)
        };
        val answer=minOf(check(tops[0]),check(bottoms[0]));
        return if(answer==Int.MAX_VALUE)-1 else answer
    }
}
