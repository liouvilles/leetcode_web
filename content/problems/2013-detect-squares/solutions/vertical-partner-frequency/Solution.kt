class DetectSquares {
    private val columns=HashMap<Int,MutableMap<Int,Int>>();
    fun add(point:IntArray){
        val column=columns.getOrPut(point[0]){
            HashMap()
        };
        column[point[1]]=(column[point[1]]?:0)+1
    }
    private fun frequency(x:Int,y:Int)=columns[x]?.get(y)?:0;
    fun count(point:IntArray):Int{
        val x=point[0];
        val y=point[1];
        var answer=0;
        for((otherY,vertical) in columns[x]?:emptyMap()){
            if(otherY==y)continue;
            val side=kotlin.math.abs(otherY-y);
            answer+=vertical*frequency(x+side,y)*frequency(x+side,otherY);
            answer+=vertical*frequency(x-side,y)*frequency(x-side,otherY)
        };
        return answer
    }
}
