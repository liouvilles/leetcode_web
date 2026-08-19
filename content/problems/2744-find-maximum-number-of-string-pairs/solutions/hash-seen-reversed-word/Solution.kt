class Solution {
    fun maximumNumberOfStringPairs(words:Array<String>):Int{
        val seen=HashSet<String>();
        var answer=0;
        for(word in words){
            val reversed=word.reversed();
            if(reversed in seen)answer++ else seen.add(word)
        };
        return answer
    }
}
