class Solution {
    private fun longest(value:String,k:Int,changedValue:Char):Int{
        var left=0;
        var changed=0;
        var answer=0;
        for(right in value.indices){
            if(value[right]==changedValue)changed++;
            while(changed>k)if(value[left++]==changedValue)changed--;
            answer=maxOf(answer,right-left+1)
        };
        return answer
    };
    fun maxConsecutiveAnswers(answerKey:String,k:Int)=maxOf(longest(answerKey,k,'T'),longest(answerKey,k,'F'))
}
