class Solution {
    fun maxWidthOfVerticalArea(points:Array<IntArray>):Int{
        val x=points.map{
            it[0]
        }.sorted();
        var answer=0;
        for(i in 1 until x.size)answer=maxOf(answer,x[i]-x[i-1]);
        return answer
    }
}
