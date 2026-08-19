class Solution {
    fun truncateSentence(sentence:String,k:Int):String=sentence.split(' ').take(k).joinToString(" ")
}
