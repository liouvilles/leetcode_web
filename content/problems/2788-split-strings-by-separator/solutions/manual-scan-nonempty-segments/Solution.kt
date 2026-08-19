class Solution {
    fun splitWordsBySeparator(words:List<String>,separator:Char):List<String>{
        val answer=mutableListOf<String>();
        for(word in words){
            var start=0;
            for(end in 0..word.length)if(end==word.length||word[end]==separator){
                if(end>start)answer.add(word.substring(start,end));
                start=end+1
            }
        };
        return answer
    }
}
