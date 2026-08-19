class Solution {
    fun longestAwesome(text:String):Int{
        val earliest=IntArray(1 shl 10){
            -2
        };
        earliest[0]=-1;
        var mask=0;
        var answer=0;
        for(i in text.indices){
            mask=mask xor (1 shl (text[i]-'0'));
            if(earliest[mask]!=-2)answer=maxOf(answer,i-earliest[mask]);
            for(digit in 0..9){
                val other=mask xor (1 shl digit);
                if(earliest[other]!=-2)answer=maxOf(answer,i-earliest[other])
            };
            if(earliest[mask]==-2)earliest[mask]=i
        };
        return answer
    }
}
