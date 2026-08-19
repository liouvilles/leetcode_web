class Solution {
    fun longestWord(words:Array<String>):String{
        val dictionary=words.toHashSet();
        words.sort();
        var answer="";
        for(word in words){
            var valid=true;
            for(end in 1 until word.length)if(word.substring(0,end) !in dictionary){
                valid=false;
                break
            };
            if(valid&&word.length>answer.length)answer=word
        };
        return answer
    }
}
