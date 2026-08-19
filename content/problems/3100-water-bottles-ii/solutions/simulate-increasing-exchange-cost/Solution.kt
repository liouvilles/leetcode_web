class Solution {
    fun maxBottlesDrunk(numBottles:Int,numExchange:Int):Int{
        var exchange=numExchange;
        var drunk=numBottles;
        var empty=numBottles;
        while(empty>=exchange){
            empty-=exchange;
            empty++;
            drunk++;
            exchange++
        };
        return drunk
    }
}
