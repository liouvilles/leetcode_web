class Solution {
    fun distinctNames(ideas:Array<String>):Long{
        val groups=Array(26){
            HashSet<String>()
        };
        for(idea in ideas)groups[idea[0]-'a'].add(idea.substring(1));
        var answer=0L;
        for(i in 0 until 26)for(j in i+1 until 26){
            var common=0;
            for(suffix in groups[i])if(suffix in groups[j])common++;
            answer+=2L*(groups[i].size-common)*(groups[j].size-common)
        };
        return answer
    }
}
