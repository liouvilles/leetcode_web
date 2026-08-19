class Solution {
    private fun count(darts:Array<IntArray>,x:Double,y:Double,r:Int):Int=darts.count{
        val dx=it[0]-x;
        val dy=it[1]-y;
        dx*dx+dy*dy<=r.toDouble()*r+1e-7
    };
    fun numPoints(darts:Array<IntArray>,r:Int):Int{
        var answer=1;
        for(i in darts.indices)for(j in i+1 until darts.size){
            val dx=(darts[j][0]-darts[i][0]).toDouble();
            val dy=(darts[j][1]-darts[i][1]).toDouble();
            val distance=kotlin.math.hypot(dx,dy);
            if(distance==0.0||distance>2.0*r+1e-9)continue;
            val middleX=(darts[i][0]+darts[j][0])/2.0;
            val middleY=(darts[i][1]+darts[j][1])/2.0;
            val height=kotlin.math.sqrt(maxOf(0.0,r.toDouble()*r-distance*distance/4));
            val offsetX=-dy/distance*height;
            val offsetY=dx/distance*height;
            answer=maxOf(answer,count(darts,middleX+offsetX,middleY+offsetY,r),count(darts,middleX-offsetX,middleY-offsetY,r))
        };
        return answer
    }
}
