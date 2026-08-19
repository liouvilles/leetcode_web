class Solution {
    fun areOccurrencesEqual(s:String):Boolean{
        val frequency=IntArray(26);
        for(letter in s)frequency[letter-'a']++;
        val values=frequency.filter{
            it>0
        };
        return values.all{
            it==values[0]
        }
    }
}
