class Solution {
    fun largestMerge(word1:String,word2:String):String{
        val answer=StringBuilder();
        var first=0;
        var second=0;
        while(first<word1.length&&second<word2.length)if(word1.substring(first)>word2.substring(second))answer.append(word1[first++]) else answer.append(word2[second++]);
        answer.append(word1.substring(first));
        answer.append(word2.substring(second));
        return answer.toString()
    }
}
