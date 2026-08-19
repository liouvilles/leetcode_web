class Solution {
    vector<int> nums,powers,memo;
    int slots;
    int dfs(int index,int mask){
        if(index==(int)nums.size())return 0;
        if(memo[mask]>=0)return memo[mask];
        int best=0;
        for(int slot=0;slot<slots;++slot)if(mask/powers[slot]%3<2)best=max(best,(nums[index]&(slot+1))+dfs(index+1,mask+powers[slot]));
        return memo[mask]=best;
    }
    public:int maximumANDSum(vector<int>& nums,int numSlots){
        this->nums=nums;
        slots=numSlots;
        powers.resize(slots);
        int states=1;
        for(int i=0;i<slots;++i){
            powers[i]=states;
            states*=3;
        }
        memo.assign(states,-1);
        return dfs(0,0);
    }
};
