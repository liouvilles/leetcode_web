class Solution {
    fun longestStrChain(words:Array<String>):Int{
        words.sortBy{
            it.length
        };
        val best=mutableMapOf<String,Int>();
        var answer=1;
        for(word in words){
            var length=1;
            for(i in word.indices){
                val predecessor=word.removeRange(i,i+1);
                length=maxOf(length,(best[predecessor]?:0)+1)
            };
            best[word]=length;
            answer=maxOf(answer,length)
        };
        return answer
    }
}
