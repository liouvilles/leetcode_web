class Solution {
    public: int minCostToMoveChips(vector<int>& position){
        int even=0,odd=0;
        for(int value:position)value%2?++odd:++even;
        return min(even,odd);
    }
};
