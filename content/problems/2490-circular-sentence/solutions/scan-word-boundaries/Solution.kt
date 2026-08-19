class Solution {
    fun isCircularSentence(sentence:String):Boolean{
        if(sentence.first()!=sentence.last())return false;
        for(i in 1 until sentence.lastIndex)if(sentence[i]==' '&&sentence[i-1]!=sentence[i+1])return false;
        return true
    }
}
