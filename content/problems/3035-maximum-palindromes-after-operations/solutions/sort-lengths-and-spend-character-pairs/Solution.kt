class Solution {
    fun maxPalindromesAfterOperations(words:Array<String>):Int{
        val frequency=IntArray(26);
        val lengths=IntArray(words.size);
        for(index in words.indices){
            lengths[index]=words[index].length;
            for(letter in words[index])frequency[letter-'a']++
        };
        var pairs=frequency.sumOf{
            it/2
        };
        lengths.sort();
        var answer=0;
        for(length in lengths){
            val need=length/2;
            if(pairs<need)break;
            pairs-=need;
            answer++
        };
        return answer
    }
}
