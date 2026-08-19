class Solution {
    fun largestTriangleArea(points:Array<IntArray>):Double{
        var twice=0L;
        for(i in points.indices)for(j in i+1 until points.size)for(k in j+1 until points.size){
            val cross=(points[j][0]-points[i][0]).toLong()*(points[k][1]-points[i][1])-(points[j][1]-points[i][1]).toLong()*(points[k][0]-points[i][0]);
            twice=maxOf(twice,kotlin.math.abs(cross))
        };
        return twice/2.0
    }
}
