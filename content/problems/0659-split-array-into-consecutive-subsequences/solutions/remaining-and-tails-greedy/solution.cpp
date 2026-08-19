class Solution {
    public: bool isPossible(vector<int>& nums){
        unordered_map<int,int> remaining,tails;
        for(int value:nums)++remaining[value];
        for(int value:nums){
            if(remaining[value]==0)continue;
            --remaining[value];
            if(tails[value-1]>0){
                --tails[value-1];
                ++tails[value];
            }else if(remaining[value+1]>0&&remaining[value+2]>0){
                --remaining[value+1];
                --remaining[value+2];
                ++tails[value+2];
            }else return false;
        }
        return true;
    }
};
