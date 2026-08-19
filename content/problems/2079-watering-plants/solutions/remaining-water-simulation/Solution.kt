class Solution {
    fun wateringPlants(plants:IntArray,capacity:Int):Int{
        var water=capacity;
        var steps=0;
        for(i in plants.indices){
            if(water<plants[i]){
                steps+=2*i;
                water=capacity
            };
            steps++;
            water-=plants[i]
        };
        return steps
    }
}
