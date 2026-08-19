class Solution {
    fun restoreMatrix(rowSum:IntArray,colSum:IntArray):Array<IntArray>{
        val matrix=Array(rowSum.size){
            IntArray(colSum.size)
        };
        var row=0;
        var col=0;
        while(row<rowSum.size&&col<colSum.size){
            val value=minOf(rowSum[row],colSum[col]);
            matrix[row][col]=value;
            rowSum[row]-=value;
            colSum[col]-=value;
            if(rowSum[row]==0)row++;
            if(colSum[col]==0)col++
        };
        return matrix
    }
}
