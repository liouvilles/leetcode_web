class Solution {
    fun scoreOfParentheses(s:String):Int{
        var depth=0;
        var score=0;
        for(i in s.indices)if(s[i]=='(')depth++ else{
            depth--;
            if(s[i-1]=='(')score+=1 shl depth
        };
        return score
    }
}
