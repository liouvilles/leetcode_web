class Solution {
    fun minimumCost(source:String,target:String,original:CharArray,changed:CharArray,cost:IntArray):Long{
        val infinity=Long.MAX_VALUE/4;
        val distance=Array(26){
            LongArray(26){
                infinity
            }
        };
        for(letter in 0 until 26)distance[letter][letter]=0;
        for(i in cost.indices){
            val from=original[i]-'a';
            val to=changed[i]-'a';
            distance[from][to]=minOf(distance[from][to],cost[i].toLong())
        };
        for(middle in 0 until 26)for(from in 0 until 26)for(to in 0 until 26)if(distance[from][middle]<infinity&&distance[middle][to]<infinity)distance[from][to]=minOf(distance[from][to],distance[from][middle]+distance[middle][to]);
        var answer=0L;
        for(i in source.indices){
            val value=distance[source[i]-'a'][target[i]-'a'];
            if(value==infinity)return -1;
            answer+=value
        };
        return answer
    }
}
