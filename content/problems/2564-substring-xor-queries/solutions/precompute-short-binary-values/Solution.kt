class Solution {
    fun substringXorQueries(s:String,queries:Array<IntArray>):Array<IntArray>{
        val positions=HashMap<Int,IntArray>();
        for(start in s.indices){
            if(s[start]=='0'){
                positions.putIfAbsent(0,intArrayOf(start,start));
                continue
            };
            var value=0;
            for(end in start until minOf(s.length,start+30)){
                value=(value shl 1)+(s[end]-'0');
                positions.putIfAbsent(value,intArrayOf(start,end))
            }
        };
        return Array(queries.size){
            positions[queries[it][0] xor queries[it][1]]?:intArrayOf(-1,-1)
        }
    }
}
