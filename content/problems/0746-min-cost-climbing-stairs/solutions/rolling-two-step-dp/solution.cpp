class Solution {
    public: int minCostClimbingStairs(vector<int>& cost){
        int previousTwo=0,previousOne=0;
        for(int position=2;position<=(int)cost.size();++position){
            int current=min(previousOne+cost[position-1],previousTwo+cost[position-2]);
            previousTwo=previousOne;
            previousOne=current;
        }
        return previousOne;
    }
};
