class Solution {
    fun wonderfulSubstrings(word:String):Long{
        val frequency=LongArray(1 shl 10);
        frequency[0]=1;
        var answer=0L;
        var mask=0;
        for(letter in word){
            mask=mask xor (1 shl (letter-'a'));
            answer+=frequency[mask];
            for(bit in 0 until 10)answer+=frequency[mask xor (1 shl bit)];
            frequency[mask]++
        };
        return answer
    }
}
