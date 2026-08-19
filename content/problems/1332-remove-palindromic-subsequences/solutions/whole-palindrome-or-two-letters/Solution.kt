class Solution {
    fun removePalindromeSub(s:String):Int{
        var left=0;
        var right=s.lastIndex;
        while(left<right)if(s[left++]!=s[right--])return 2;
        return 1
    }
}
