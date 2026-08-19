class Solution {
    fun bestCoordinate(towers:Array<IntArray>,radius:Int):IntArray{
        var best=-1;
        var bestX=0;
        var bestY=0;
        for(x in 0..50)for(y in 0..50){
            var quality=0;
            for(tower in towers){
                val dx=x-tower[0];
                val dy=y-tower[1];
                val distance=kotlin.math.sqrt((dx*dx+dy*dy).toDouble());
                if(distance<=radius)quality+=(tower[2]/(1+distance)).toInt()
            };
            if(quality>best){
                best=quality;
                bestX=x;
                bestY=y
            }
        };
        return intArrayOf(bestX,bestY)
    }
}
