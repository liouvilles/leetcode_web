class Solution {
    fun eliminateMaximum(dist:IntArray,speed:IntArray):Int{
        val arrival=IntArray(dist.size){
            (dist[it]+speed[it]-1)/speed[it]
        };
        arrival.sort();
        for(i in arrival.indices)if(arrival[i]<=i)return i;
        return arrival.size
    }
}
