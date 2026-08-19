class Solution {
    fun transpose(matrix:Array<IntArray>):Array<IntArray>{
        val rows=matrix.size;
        val columns=matrix[0].size;
        return Array(columns){
            c->IntArray(rows){
                r->matrix[r][c]
            }
        }
    }
}
