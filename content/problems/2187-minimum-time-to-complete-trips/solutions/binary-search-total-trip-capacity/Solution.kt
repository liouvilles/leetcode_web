class Solution {
    fun minimumTime(time:IntArray,totalTrips:Int):Long{
        var left=1L;
        var right=time.minOrNull()!!.toLong()*totalTrips;
        while(left<right){
            val middle=(left+right)/2;
            var trips=0L;
            for(duration in time){
                trips+=middle/duration;
                if(trips>=totalTrips)break
            };
            if(trips>=totalTrips)right=middle else left=middle+1
        };
        return left
    }
}
