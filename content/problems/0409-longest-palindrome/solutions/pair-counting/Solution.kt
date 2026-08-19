class Solution {
    fun longestPalindrome(s:String):Int{
        val counts=IntArray(128);
        for(c in s)counts[c.code]++;
        var answer=0;
        for(count in counts)answer+=count/2*2;
        return if(answer<s.length)answer+1 else answer
    }
}
