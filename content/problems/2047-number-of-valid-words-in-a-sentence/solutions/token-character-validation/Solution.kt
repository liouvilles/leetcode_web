class Solution {
    private fun valid(token:String):Boolean{
        var hyphens=0;
        var punctuation=0;
        for(i in token.indices){
            val value=token[i];
            if(value.isDigit())return false;
            if(value=='-'){
                if(++hyphens>1||i==0||i==token.lastIndex||!token[i-1].isLowerCase()||!token[i+1].isLowerCase())return false
            }else if(value in "!.,"){
                if(++punctuation>1||i!=token.lastIndex)return false
            }else if(!value.isLowerCase())return false
        };
        return true
    };
    fun countValidWords(sentence:String)=sentence.trim().split(Regex("\\s+")).count{
        valid(it)
    }
}
