class Solution {
    fun longestValidSubstring(word:String,forbidden:List<String>):Int{
        val banned=forbidden.toHashSet();
        var left=0;
        var answer=0;
        for(right in word.indices){
            for(start in right downTo maxOf(left,right-9))if(word.substring(start,right+1) in banned){
                left=start+1;
                break
            };
            answer=maxOf(answer,right-left+1)
        };
        return answer
    }
}
