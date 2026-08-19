class Solution {
    fun captureForts(forts:IntArray):Int{
        var previous=-1;
        var answer=0;
        for(i in forts.indices)if(forts[i]!=0){
            if(previous>=0&&forts[previous]!=forts[i])answer=maxOf(answer,i-previous-1);
            previous=i
        };
        return answer
    }
}
