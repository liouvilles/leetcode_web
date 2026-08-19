class Solution {
    fun minimumBoxes(n:Int):Int{
        var height=0;
        var used=0;
        var floor=0;
        while(true){
            val nextLayer=(height+1)*(height+2)/2;
            if(used+nextLayer>n)break;
            height++;
            used+=nextLayer;
            floor+=height
        };
        var remaining=n-used;
        var capacity=1;
        while(remaining>0){
            remaining-=capacity++;
            floor++
        };
        return floor
    }
}
