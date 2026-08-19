class Solution {
    fun restoreString(text:String,indices:IntArray):String{
        val answer=CharArray(text.length);
        for(i in text.indices)answer[indices[i]]=text[i];
        return answer.concatToString()
    }
}
