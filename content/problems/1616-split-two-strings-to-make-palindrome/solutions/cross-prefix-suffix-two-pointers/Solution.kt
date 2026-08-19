class Solution {
    private fun palindrome(text:String,leftValue:Int,rightValue:Int):Boolean{
        var left=leftValue;
        var right=rightValue;
        while(left<right)if(text[left++]!=text[right--])return false;
        return true
    };
    private fun check(first:String,second:String):Boolean{
        var left=0;
        var right=first.lastIndex;
        while(left<right&&first[left]==second[right]){
            left++;
            right--
        };
        return palindrome(first,left,right)||palindrome(second,left,right)
    };
    fun checkPalindromeFormation(a:String,b:String):Boolean=check(a,b)||check(b,a)
}
