class Solution {
    private fun palindrome(word:String):Boolean{
        var left=0;
        var right=word.lastIndex;
        while(left<right)if(word[left++]!=word[right--])return false;
        return true
    };
    fun firstPalindrome(words:Array<String>)=words.firstOrNull{
        palindrome(it)
    }?:""
}
