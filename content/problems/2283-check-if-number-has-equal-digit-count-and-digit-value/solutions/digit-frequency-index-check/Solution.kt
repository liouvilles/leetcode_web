class Solution {
    fun digitCount(num:String):Boolean{
        val count=IntArray(10);
        for(ch in num)count[ch-'0']++;
        return num.indices.all{
            count[it]==num[it]-'0'
        }
    }
}
