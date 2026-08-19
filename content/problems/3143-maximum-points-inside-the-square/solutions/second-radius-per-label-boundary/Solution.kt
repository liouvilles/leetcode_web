class Solution {
    fun maxPointsInsideSquare(points:Array<IntArray>,s:String):Int{
        val first=IntArray(26){
            Int.MAX_VALUE
        };
        val second=IntArray(26){
            Int.MAX_VALUE
        };
        for(index in points.indices){
            val label=s[index]-'a';
            val radius=maxOf(kotlin.math.abs(points[index][0]),kotlin.math.abs(points[index][1]));
            if(radius<first[label]){
                second[label]=first[label];
                first[label]=radius
            }else if(radius<second[label])second[label]=radius
        };
        var forbidden=Int.MAX_VALUE;
        for(radius in second)forbidden=minOf(forbidden,radius);
        var answer=0;
        for(point in points)if(maxOf(kotlin.math.abs(point[0]),kotlin.math.abs(point[1]))<forbidden)answer++;
        return answer
    }
}
