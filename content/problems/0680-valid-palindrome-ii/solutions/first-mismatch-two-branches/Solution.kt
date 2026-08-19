class Solution {
    fun validPalindrome(s:String):Boolean{
        var left=0;
        var right=s.lastIndex;
        while(left<right&&s[left]==s[right]){
            left++;
            right--
        };
        return left>=right||palindrome(s,left+1,right)||palindrome(s,left,right-1)
    };
    private fun palindrome(s:String,start:Int,end:Int):Boolean{
        var left=start;
        var right=end;
        while(left<right)if(s[left++]!=s[right--])return false;
        return true
    }
}
