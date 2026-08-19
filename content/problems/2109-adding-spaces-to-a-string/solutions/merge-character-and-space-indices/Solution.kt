class Solution {
    fun addSpaces(s:String,spaces:IntArray):String{
        val answer=StringBuilder();
        var next=0;
        for(i in s.indices){
            if(next<spaces.size&&spaces[next]==i){
                answer.append(' ');
                next++
            };
            answer.append(s[i])
        };
        return answer.toString()
    }
}
