class Solution {
    private fun mask(word:String):Int{
        var value=0;
        for(ch in word)value=value or (1 shl (ch-'a'));
        return value
    };
    fun wordCount(startWords:Array<String>,targetWords:Array<String>):Int{
        val starts=startWords.mapTo(HashSet()){
            mask(it)
        };
        var answer=0;
        for(word in targetWords){
            val value=mask(word);
            var bits=value;
            while(bits!=0){
                val bit=bits and -bits;
                if((value xor bit) in starts){
                    answer++;
                    break
                };
                bits=bits and (bits-1)
            }
        };
        return answer
    }
}
