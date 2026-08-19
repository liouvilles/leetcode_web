class Solution {
    fun visiblePoints(points:List<List<Int>>,angle:Int,location:List<Int>):Int{
        if(angle>=360)return points.size;
        val angles=mutableListOf<Double>();
        var same=0;
        for(point in points){
            val dx=point[0]-location[0];
            val dy=point[1]-location[1];
            if(dx==0&&dy==0)same++ else angles.add(kotlin.math.atan2(dy.toDouble(),dx.toDouble()))
        };
        angles.sort();
        val original=angles.size;
        for(i in 0 until original)angles.add(angles[i]+2*Math.PI);
        val width=Math.toRadians(angle.toDouble());
        var left=0;
        var best=0;
        for(right in angles.indices){
            while(angles[right]-angles[left]>width+1e-12)left++;
            best=maxOf(best,minOf(original,right-left+1))
        };
        return best+same
    }
}
