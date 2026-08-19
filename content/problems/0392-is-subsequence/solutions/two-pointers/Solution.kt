class Solution {
    fun isSubsequence(s:String,t:String):Boolean{
        var matched=0;
        for(c in t)if(matched<s.length&&c==s[matched])matched++;
        return matched==s.length
    }
}
