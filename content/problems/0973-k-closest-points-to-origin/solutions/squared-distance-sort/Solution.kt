class Solution {
    fun kClosest(points:Array<IntArray>,k:Int):Array<IntArray>{
        points.sortBy{
            it[0].toLong()*it[0]+it[1].toLong()*it[1]
        };
        return points.copyOfRange(0,k)
    }
}
