class Solution {
    fun makeEqual(words:Array<String>):Boolean{
        val frequency=IntArray(26);
        for(word in words)for(letter in word)frequency[letter-'a']++;
        return frequency.all{
            it%words.size==0
        }
    }
}
