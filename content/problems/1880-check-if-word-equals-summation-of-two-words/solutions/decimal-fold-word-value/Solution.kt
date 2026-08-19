class Solution {
    private fun value(word:String):Int{
        var result=0;
        for(letter in word)result=result*10+(letter-'a');
        return result
    };
    fun isSumEqual(firstWord:String,secondWord:String,targetWord:String):Boolean=value(firstWord)+value(secondWord)==value(targetWord)
}
