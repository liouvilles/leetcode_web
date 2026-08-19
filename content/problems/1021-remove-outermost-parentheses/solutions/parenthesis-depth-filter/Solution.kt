class Solution {
    fun removeOuterParentheses(s:String):String{
        val answer=StringBuilder();
        var depth=0;
        for(ch in s)if(ch=='('){
            if(depth++>0)answer.append(ch)
        }else{
            depth--;
            if(depth>0)answer.append(ch)
        };
        return answer.toString()
    }
}
