class Solution {
    fun isPrefixOfWord(sentence:String,searchWord:String):Int{
        for((index,word)in sentence.split(' ').withIndex())if(word.startsWith(searchWord))return index+1;
        return -1
    }
}
