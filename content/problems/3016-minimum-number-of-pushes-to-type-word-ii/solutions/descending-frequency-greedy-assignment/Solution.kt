class Solution {
    fun minimumPushes(word:String):Int{
        val frequency=IntArray(26);
        for(letter in word)frequency[letter-'a']++;
        frequency.sort();
        var answer=0;
        for(rank in 0 until 26)answer+=frequency[25-rank]*(rank/8+1);
        return answer
    }
}
