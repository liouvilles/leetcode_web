class Solution {
    fun removeAnagrams(words:Array<String>):List<String>{
        val answer=mutableListOf<String>();
        var previous="";
        for(word in words){
            val current=word.toCharArray().sorted().joinToString("");
            if(current!=previous){
                answer.add(word);
                previous=current
            }
        };
        return answer
    }
}
