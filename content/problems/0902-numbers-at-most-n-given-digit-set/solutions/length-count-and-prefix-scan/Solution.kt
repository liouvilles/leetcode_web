class Solution {
    fun atMostNGivenDigitSet(digits:Array<String>,n:Int):Int{
        val text=n.toString();
        val base=digits.size;
        var answer=0;
        for(length in 1 until text.length)answer+=power(base,length);
        for(i in text.indices){
            var less=0;
            var equal=false;
            for(digit in digits)if(digit[0]<text[i])less++ else if(digit[0]==text[i])equal=true;
            answer+=less*power(base,text.length-1-i);
            if(!equal)return answer
        };
        return answer+1
    };
    private fun power(base:Int,exponentInput:Int):Int{
        var exponent=exponentInput;
        var result=1;
        while(exponent-->0)result*=base;
        return result
    }
}
