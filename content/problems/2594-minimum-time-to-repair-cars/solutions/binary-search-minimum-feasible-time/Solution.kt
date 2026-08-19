class Solution {
    fun repairCars(ranks:IntArray,cars:Int):Long{
        var left=0L;
        var right=ranks.minOrNull()!!.toLong()*cars*cars;
        while(left<right){
            val middle=left+(right-left)/2;
            var total=0L;
            for(rank in ranks){
                total+=kotlin.math.sqrt((middle/rank).toDouble()).toLong();
                if(total>=cars)break
            };
            if(total>=cars)right=middle else left=middle+1
        };
        return left
    }
}
