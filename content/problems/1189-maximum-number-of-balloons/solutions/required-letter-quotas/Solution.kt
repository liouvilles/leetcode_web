class Solution {
    fun maxNumberOfBalloons(text:String):Int{
        val count=IntArray(26);
        for(ch in text)count[ch-'a']++;
        return minOf(count['b'-'a'],count['a'-'a'],count['n'-'a'],count['l'-'a']/2,count['o'-'a']/2)
    }
}
