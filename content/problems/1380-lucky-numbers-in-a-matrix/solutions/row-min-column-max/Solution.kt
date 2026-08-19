class Solution {
    fun luckyNumbers(matrix:Array<IntArray>):List<Int>{
        val rows=matrix.size;
        val cols=matrix[0].size;
        val rowMin=IntArray(rows){
            Int.MAX_VALUE
        };
        val colMax=IntArray(cols){
            Int.MIN_VALUE
        };
        for(row in 0 until rows)for(col in 0 until cols){
            rowMin[row]=minOf(rowMin[row],matrix[row][col]);
            colMax[col]=maxOf(colMax[col],matrix[row][col])
        };
        val answer=mutableListOf<Int>();
        for(row in 0 until rows)for(col in 0 until cols)if(matrix[row][col]==rowMin[row]&&matrix[row][col]==colMax[col])answer.add(matrix[row][col]);
        return answer
    }
}
