class Solution {
    fun maxDistance(colors:IntArray):Int{
        var answer=0;
        for(i in colors.indices){
            if(colors[i]!=colors[0])answer=maxOf(answer,i);
            if(colors[i]!=colors.last())answer=maxOf(answer,colors.lastIndex-i)
        };
        return answer
    }
}
