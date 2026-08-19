class Solution {
    fun largeGroupPositions(s:String):List<List<Int>>{
        val answer=mutableListOf<List<Int>>();
        var start=0;
        while(start<s.length){
            var end=start+1;
            while(end<s.length&&s[end]==s[start])end++;
            if(end-start>=3)answer.add(listOf(start,end-1));
            start=end
        };
        return answer
    }
}
