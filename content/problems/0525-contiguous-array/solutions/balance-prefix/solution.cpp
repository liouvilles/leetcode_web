class Solution {
    public: int findMaxLength(vector<int>& nums){
        unordered_map<int,int> first{
            {
                0,-1
            }
        };
        int balance=0,best=0;
        for(int i=0;i<(int)nums.size();++i){
            balance+=nums[i]?1:-1;
            auto it=first.find(balance);
            if(it!=first.end())best=max(best,i-it->second);
            else first[balance]=i;
        }
        return best;
    }
};
