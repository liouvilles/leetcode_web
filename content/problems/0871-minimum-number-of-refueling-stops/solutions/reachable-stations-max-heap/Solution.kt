class Solution {
    fun minRefuelStops(target:Int,startFuel:Int,stations:Array<IntArray>):Int{
        val heap=java.util.PriorityQueue<Int>(compareByDescending{
            it
        });
        var fuel=startFuel.toLong();
        var index=0;
        var stops=0;
        while(fuel<target){
            while(index<stations.size&&stations[index][0]<=fuel)heap.add(stations[index++][1]);
            if(heap.isEmpty())return -1;
            fuel+=heap.remove();
            stops++
        };
        return stops
    }
}
