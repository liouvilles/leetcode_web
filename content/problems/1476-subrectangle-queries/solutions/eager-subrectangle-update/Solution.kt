class SubrectangleQueries(rectangle:Array<IntArray>){
    private val rectangle=Array(rectangle.size){
        rectangle[it].copyOf()
    };
    fun updateSubrectangle(row1:Int,col1:Int,row2:Int,col2:Int,newValue:Int){
        for(row in row1..row2)for(col in col1..col2)rectangle[row][col]=newValue
    };
    fun getValue(row:Int,col:Int):Int=rectangle[row][col]
}
