class Solution {
    fun countVowels(word:String):Long{
        var answer=0L;
        for(i in word.indices)if(word[i] in "aeiou")answer+=(i+1).toLong()*(word.length-i);
        return answer
    }
}
