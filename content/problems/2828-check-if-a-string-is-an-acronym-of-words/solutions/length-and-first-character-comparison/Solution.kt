class Solution {
    fun isAcronym(words:List<String>,s:String):Boolean{
        if(words.size!=s.length)return false;
        return words.indices.all{
            words[it][0]==s[it]
        }
    }
}
