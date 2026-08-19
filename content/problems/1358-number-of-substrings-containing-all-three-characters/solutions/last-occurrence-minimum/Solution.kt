class Solution {
    fun numberOfSubstrings(text:String):Int{
        val last=intArrayOf(-1,-1,-1);
        var answer=0;
        for(i in text.indices){
            last[text[i]-'a']=i;
            answer+=1+minOf(last[0],last[1],last[2])
        };
        return answer
    }
}
