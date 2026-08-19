class Solution {
    fun minimizeStringValue(s:String):String{
        val frequency=IntArray(26);
        var missing=0;
        for(letter in s)if(letter=='?')missing++ else frequency[letter-'a']++;
        val queue=java.util.PriorityQueue<IntArray>(compareBy<IntArray>{
            it[0]
        }.thenBy{
            it[1]
        });
        for(letter in 0 until 26)queue.add(intArrayOf(frequency[letter],letter));
        val replacements=CharArray(missing);
        for(index in replacements.indices){
            val entry=queue.poll();
            replacements[index]=('a'.code+entry[1]).toChar();
            entry[0]++;
            queue.add(entry)
        };
        replacements.sort();
        val answer=s.toCharArray();
        var index=0;
        for(position in answer.indices)if(answer[position]=='?')answer[position]=replacements[index++];
        return answer.concatToString()
    }
}
