class Solution {
    fun minGroupsForValidAssignment(balls:IntArray):Int{
        val frequencies=HashMap<Int,Int>();
        for(ball in balls)frequencies[ball]=(frequencies[ball]?:0)+1;
        var smallest=balls.size;
        for(frequency in frequencies.values)smallest=minOf(smallest,frequency);
        for(size in smallest downTo 1){
            var groups=0;
            var feasible=true;
            for(frequency in frequencies.values){
                val quotient=frequency/size;
                val remainder=frequency%size;
                if(quotient<remainder){
                    feasible=false;
                    break
                };
                groups+=(frequency+size)/(size+1)
            };
            if(feasible)return groups
        };
        return balls.size
    }
}
