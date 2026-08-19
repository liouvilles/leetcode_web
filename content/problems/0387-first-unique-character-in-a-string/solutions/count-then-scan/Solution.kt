class Solution {
    fun firstUniqChar(s:String):Int{
        val counts=IntArray(26);
        for(c in s)counts[c-'a']++;
        for(i in s.indices)if(counts[s[i]-'a']==1)return i;
        return -1
    }
}
