class Solution {
    fun carPooling(trips:Array<IntArray>,capacity:Int):Boolean{
        val difference=IntArray(1001);
        for(trip in trips){
            difference[trip[1]]+=trip[0];
            difference[trip[2]]-=trip[0]
        };
        var onboard=0;
        for(change in difference)if(run{
            onboard+=change;
            onboard
        }>capacity)return false;
        return true
    }
}
