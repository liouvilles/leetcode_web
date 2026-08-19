class Solution {
    fun countConsistentStrings(allowed:String,words:Array<String>):Int{
        val valid=BooleanArray(26);
        for(letter in allowed)valid[letter-'a']=true;
        return words.count{
            word->word.all{
                valid[it-'a']
            }
        }
    }
}
