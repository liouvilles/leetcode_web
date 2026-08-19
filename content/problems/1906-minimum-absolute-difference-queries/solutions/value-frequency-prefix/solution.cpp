class Solution {
    public: vector<int> minDifference(vector<int>& nums,vector<vector<int>>& queries){
        vector<array<int,101>> prefix(nums.size()+1);
        for(int i=0;i<(int)nums.size();++i){
            prefix[i+1]=prefix[i];
            ++prefix[i+1][nums[i]];
        }
        vector<int> answer;
        for(auto& query:queries){
            int previous=-1,best=101;
            for(int value=1;value<=100;++value)if(prefix[query[1]+1][value]>prefix[query[0]][value]){
                if(previous!=-1)best=min(best,value-previous);
                previous=value;
            }
            answer.push_back(best==101?-1:best);
        }
        return answer;
    }
};
