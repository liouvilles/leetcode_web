class Solution {
    fun matrixSumQueries(n:Int,queries:Array<IntArray>):Long{
        val seenRow=BooleanArray(n);
        val seenCol=BooleanArray(n);
        var usedRows=0;
        var usedCols=0;
        var answer=0L;
        for(i in queries.lastIndex downTo 0){
            val type=queries[i][0];
            val index=queries[i][1];
            val value=queries[i][2];
            if(type==0&&!seenRow[index]){
                answer+=value.toLong()*(n-usedCols);
                seenRow[index]=true;
                usedRows++
            }else if(type==1&&!seenCol[index]){
                answer+=value.toLong()*(n-usedRows);
                seenCol[index]=true;
                usedCols++
            }
        };
        return answer
    }
}
