class Solution {
    fun maxDepthAfterSplit(seq:String):IntArray{
        val answer=IntArray(seq.length);
        var depth=0;
        for(i in seq.indices)if(seq[i]=='('){
            answer[i]=depth%2;
            depth++
        }else{
            depth--;
            answer[i]=depth%2
        };
        return answer
    }
}
