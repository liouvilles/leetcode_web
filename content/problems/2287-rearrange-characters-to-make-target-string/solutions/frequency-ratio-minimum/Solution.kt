class Solution {
    fun rearrangeCharacters(s:String,target:String):Int{
        val source=IntArray(26);
        val need=IntArray(26);
        for(ch in s)source[ch-'a']++;
        for(ch in target)need[ch-'a']++;
        var answer=Int.MAX_VALUE;
        for(i in 0 until 26)if(need[i]>0)answer=minOf(answer,source[i]/need[i]);
        return answer
    }
}
