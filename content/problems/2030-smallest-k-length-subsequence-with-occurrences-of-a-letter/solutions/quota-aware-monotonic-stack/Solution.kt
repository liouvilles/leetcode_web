class Solution {
    fun smallestSubsequence(s:String,k:Int,letter:Char,repetition:Int):String{
        var remainingLetter=s.count{
            it==letter
        };
        val stack=StringBuilder();
        var usedLetter=0;
        for(i in s.indices){
            val value=s[i];
            while(stack.isNotEmpty()&&stack.last()>value&&stack.length+s.length-i>k&&(stack.last()!=letter||usedLetter-1+remainingLetter>=repetition)){
                if(stack.last()==letter)usedLetter--;
                stack.deleteCharAt(stack.lastIndex)
            };
            if(stack.length<k){
                if(value==letter){
                    stack.append(value);
                    usedLetter++
                }else if(k-stack.length>repetition-usedLetter)stack.append(value)
            };
            if(value==letter)remainingLetter--
        };
        return stack.toString()
    }
}
