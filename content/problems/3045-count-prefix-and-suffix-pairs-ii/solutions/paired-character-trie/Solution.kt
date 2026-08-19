class Solution {
    fun countPrefixSuffixPairs(words:Array<String>):Long{
        val total=words.sumOf{
            it.length
        };
        val edges=HashMap<Long,Int>(total*4/3+1);
        val terminal=IntArray(total+1);
        var nodes=1;
        var answer=0L;
        for(word in words){
            var node=0;
            for(index in word.indices){
                val pair=(word[index]-'a')*26+(word[word.lastIndex-index]-'a');
                val key=(node.toLong() shl 10) or pair.toLong();
                var child=edges[key];
                if(child==null){
                    child=nodes++;
                    edges[key]=child
                };
                node=child;
                answer+=terminal[node]
            };
            terminal[node]++
        };
        return answer
    }
}
