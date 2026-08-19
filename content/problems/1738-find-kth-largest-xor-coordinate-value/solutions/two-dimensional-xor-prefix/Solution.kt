class Solution {
    fun kthLargestValue(matrix:Array<IntArray>,k:Int):Int{
        val rows=matrix.size;
        val cols=matrix[0].size;
        val prefix=Array(rows+1){
            IntArray(cols+1)
        };
        val values=IntArray(rows*cols);
        var index=0;
        for(row in 0 until rows)for(col in 0 until cols){
            prefix[row+1][col+1]=matrix[row][col] xor prefix[row][col+1] xor prefix[row+1][col] xor prefix[row][col];
            values[index++]=prefix[row+1][col+1]
        };
        values.sort();
        return values[values.size-k]
    }
}
