class Solution {
    private fun can(dist:IntArray,hour:Double,speed:Int):Boolean{
        var used=0.0;
        for(i in 0 until dist.lastIndex)used+=(dist[i]+speed-1)/speed;
        used+=dist.last().toDouble()/speed;
        return used<=hour
    };
    fun minSpeedOnTime(dist:IntArray,hour:Double):Int{
        if(hour<=dist.size-1)return -1;
        var left=1;
        var right=10_000_000;
        while(left<right){
            val middle=left+(right-left)/2;
            if(can(dist,hour,middle))right=middle else left=middle+1
        };
        return if(can(dist,hour,left))left else -1
    }
}
