class Solution {
    fun maxEqualRowsAfterFlips(matrix:Array<IntArray>):Int{
        val frequency=mutableMapOf<String,Int>();
        var answer=0;
        for(row in matrix){
            val key=row.joinToString(""){
                (it xor row[0]).toString()
            };
            val count=(frequency[key]?:0)+1;
            frequency[key]=count;
            answer=maxOf(answer,count)
        };
        return answer
    }
}
