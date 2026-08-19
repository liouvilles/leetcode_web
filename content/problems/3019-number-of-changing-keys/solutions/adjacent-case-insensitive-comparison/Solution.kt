class Solution {
    fun countKeyChanges(s:String):Int{
        var changes=0;
        for(i in 1 until s.length)if(s[i].lowercaseChar()!=s[i-1].lowercaseChar())changes++;
        return changes
    }
}
