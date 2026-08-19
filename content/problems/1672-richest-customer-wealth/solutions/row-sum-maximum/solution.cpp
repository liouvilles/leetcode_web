class Solution {
    public: int maximumWealth(vector<vector<int>>& accounts){
        int answer=0;
        for(auto& customer:accounts)answer=max(answer,accumulate(customer.begin(),customer.end(),0));
        return answer;
    }
};
