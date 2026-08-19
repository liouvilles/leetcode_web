class Solution {
    fun carFleet(target:Int,position:IntArray,speed:IntArray):Int{
        val order=position.indices.sortedByDescending{
            position[it]
        };
        var fleets=0;
        var last=-1.0;
        for(index in order){
            val time=(target-position[index]).toDouble()/speed[index];
            if(time>last){
                fleets++;
                last=time
            }
        };
        return fleets
    }
}
