class Solution {
    fun maxDistance(arrays:List<List<Int>>):Int{
        var minimum=arrays[0][0];
        var maximum=arrays[0].last();
        var best=0;
        for(i in 1 until arrays.size){
            val first=arrays[i][0];
            val last=arrays[i].last();
            best=maxOf(best,kotlin.math.abs(last-minimum),kotlin.math.abs(maximum-first));
            minimum=minOf(minimum,first);
            maximum=maxOf(maximum,last)
        };
        return best
    }
}
