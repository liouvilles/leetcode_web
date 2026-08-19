class Solution {
    fun maxScore(text:String):Int{
        var rightOnes=text.count{
            it=='1'
        };
        var leftZeros=0;
        var answer=0;
        for(i in 0 until text.lastIndex){
            if(text[i]=='0')leftZeros++ else rightOnes--;
            answer=maxOf(answer,leftZeros+rightOnes)
        };
        return answer
    }
}
