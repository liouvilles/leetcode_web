class Solution {
    public int maxBottlesDrunk(int numBottles,int numExchange){
        int drunk=numBottles,empty=numBottles;
        while(empty>=numExchange){
            empty-=numExchange;
            empty++;
            drunk++;
            numExchange++;
        }
        return drunk;
    }
}
