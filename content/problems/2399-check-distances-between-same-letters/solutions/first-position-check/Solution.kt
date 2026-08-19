class Solution {
    fun checkDistances(s:String,distance:IntArray):Boolean{
        val first=IntArray(26){
            -1
        };
        for(i in s.indices){
            val letter=s[i]-'a';
            if(first[letter]<0)first[letter]=i else if(i-first[letter]-1!=distance[letter])return false
        };
        return true
    }
}
