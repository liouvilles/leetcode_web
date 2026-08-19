class Solution {
    fun countSubstrings(s:String,c:Char):Long{
        var count=0L;
        for(letter in s)if(letter==c)count++;
        return count*(count+1)/2
    }
}
