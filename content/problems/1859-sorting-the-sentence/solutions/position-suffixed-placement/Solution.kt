class Solution {
    fun sortSentence(sentence:String):String{
        val words=sentence.split(' ');
        val result=Array(words.size){
            ""
        };
        for(word in words)result[word.last()-'1']=word.dropLast(1);
        return result.joinToString(" ")
    }
}
