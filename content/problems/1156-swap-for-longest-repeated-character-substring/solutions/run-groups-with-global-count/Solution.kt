class Solution {
    fun maxRepOpt1(text:String):Int{
        val total=IntArray(26);
        for(ch in text)total[ch-'a']++;
        val groups=mutableListOf<IntArray>();
        var index=0;
        while(index<text.length){
            var end=index+1;
            while(end<text.length&&text[end]==text[index])end++;
            groups.add(intArrayOf(text[index]-'a',end-index));
            index=end
        };
        var best=0;
        for(i in groups.indices){
            val group=groups[i];
            best=maxOf(best,minOf(total[group[0]],group[1]+1));
            if(i+2<groups.size&&groups[i+1][1]==1&&groups[i+2][0]==group[0])best=maxOf(best,minOf(total[group[0]],group[1]+groups[i+2][1]+1))
        };
        return best
    }
}
