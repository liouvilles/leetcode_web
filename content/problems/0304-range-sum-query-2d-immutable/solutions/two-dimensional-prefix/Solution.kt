class NumMatrix(matrix:Array<IntArray>){
    private val prefix=Array(matrix.size+1){
        IntArray(matrix[0].size+1)
    };
    init{
        for(r in matrix.indices)for(c in matrix[0].indices)prefix[r+1][c+1]=matrix[r][c]+prefix[r][c+1]+prefix[r+1][c]-prefix[r][c]
    }
    fun sumRegion(row1:Int,col1:Int,row2:Int,col2:Int):Int=prefix[row2+1][col2+1]-prefix[row1][col2+1]-prefix[row2+1][col1]+prefix[row1][col1]
}
