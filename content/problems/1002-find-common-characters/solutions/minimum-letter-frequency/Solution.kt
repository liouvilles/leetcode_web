class Solution {
    fun commonChars(words:Array<String>):List<String>{
        val minimum=IntArray(26){
            Int.MAX_VALUE
        };
        for(word in words){
            val frequency=IntArray(26);
            for(ch in word)frequency[ch-'a']++;
            for(i in 0..25)minimum[i]=minOf(minimum[i],frequency[i])
        };
        val answer=mutableListOf<String>();
        for(i in 0..25)repeat(minimum[i]){
            answer.add(('a'.code+i).toChar().toString())
        };
        return answer
    }
}
