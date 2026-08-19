class Solution {
    private fun countSegment(word:String,start:Int,end:Int,k:Int):Int{
        var answer=0;
        val length=end-start;
        for(kinds in 1..26){
            val window=kinds*k;
            if(window>length)break;
            val frequency=IntArray(26);
            var distinct=0;
            var exact=0;
            for(right in start until end){
                var letter=word[right]-'a';
                if(frequency[letter]==0)distinct++;
                if(frequency[letter]==k)exact--;
                frequency[letter]++;
                if(frequency[letter]==k)exact++;
                if(right-start>=window){
                    letter=word[right-window]-'a';
                    if(frequency[letter]==k)exact--;
                    frequency[letter]--;
                    if(frequency[letter]==k)exact++;
                    if(frequency[letter]==0)distinct--
                };
                if(right-start+1>=window&&distinct==kinds&&exact==kinds)answer++
            }
        };
        return answer
    }
    fun countCompleteSubstrings(word:String,k:Int):Int{
        var answer=0;
        var start=0;
        for(end in 1..word.length)if(end==word.length||kotlin.math.abs(word[end]-word[end-1])>2){
            answer+=countSegment(word,start,end,k);
            start=end
        };
        return answer
    }
}
