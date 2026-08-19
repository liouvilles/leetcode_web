class Solution {
    fun maxNumOfSubstrings(text:String):List<String>{
        val first=IntArray(26){
            -1
        };
        val last=IntArray(26);
        for(i in text.indices){
            val value=text[i]-'a';
            if(first[value]==-1)first[value]=i;
            last[value]=i
        };
        val intervals=mutableListOf<IntArray>();
        for(c in 0..25)if(first[c]!=-1){
            val start=first[c];
            var end=last[c];
            var valid=true;
            var i=start;
            while(i<=end){
                val value=text[i]-'a';
                if(first[value]<start){
                    valid=false;
                    break
                };
                end=maxOf(end,last[value]);
                i++
            };
            if(valid)intervals.add(intArrayOf(start,end))
        };
        intervals.sortBy{
            it[1]
        };
        val answer=mutableListOf<String>();
        var previous=-1;
        for(interval in intervals)if(interval[0]>previous){
            answer.add(text.substring(interval[0],interval[1]+1));
            previous=interval[1]
        };
        return answer
    }
}
