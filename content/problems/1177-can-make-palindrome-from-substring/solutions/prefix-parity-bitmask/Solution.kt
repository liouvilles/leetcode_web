class Solution {
    fun canMakePaliQueries(s:String,queries:Array<IntArray>):List<Boolean>{
        val prefix=IntArray(s.length+1);
        for(i in s.indices)prefix[i+1]=prefix[i] xor (1 shl (s[i]-'a'));
        return queries.map{
            query->Integer.bitCount(prefix[query[1]+1] xor prefix[query[0]])/2<=query[2]
        }
    }
}
