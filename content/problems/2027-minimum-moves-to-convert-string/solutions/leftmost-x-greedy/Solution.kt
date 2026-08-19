class Solution {
    fun minimumMoves(s:String):Int{
        var index=0;
        var answer=0;
        while(index<s.length)if(s[index]=='X'){
            answer++;
            index+=3
        }else index++;
        return answer
    }
}
