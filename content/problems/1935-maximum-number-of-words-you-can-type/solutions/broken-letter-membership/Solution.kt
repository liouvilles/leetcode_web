class Solution {
    fun canBeTypedWords(text:String,brokenLetters:String):Int{
        val broken=BooleanArray(26);
        for(letter in brokenLetters)broken[letter-'a']=true;
        return text.split(' ').count{
            word->word.all{
                !broken[it-'a']
            }
        }
    }
}
