class Solution {
    fun maxFreq(s:String,maxLetters:Int,minSize:Int,maxSize:Int):Int{
        val frequency=IntArray(26);
        var left=0;
        var distinct=0;
        var answer=0;
        val counts=mutableMapOf<String,Int>();
        for(right in s.indices){
            if(frequency[s[right]-'a']++==0)distinct++;
            if(right-left+1>minSize){
                if(--frequency[s[left++]-'a']==0)distinct--
            };
            if(right-left+1==minSize&&distinct<=maxLetters){
                val value=s.substring(left,right+1);
                val count=(counts[value]?:0)+1;
                counts[value]=count;
                answer=maxOf(answer,count)
            }
        };
        return answer
    }
}
