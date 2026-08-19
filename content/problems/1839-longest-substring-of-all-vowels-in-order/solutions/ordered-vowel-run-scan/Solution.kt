class Solution {
    fun longestBeautifulSubstring(word:String):Int{
        var start=0;
        var distinct=1;
        var answer=0;
        for(i in 1 until word.length){
            if(word[i]<word[i-1]){
                start=i;
                distinct=1
            }else if(word[i]>word[i-1])distinct++;
            if(distinct==5)answer=maxOf(answer,i-start+1)
        };
        return answer
    }
}
