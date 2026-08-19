class Solution {
    public:int longestEqualSubarray(vector<int>& nums,int k){
        unordered_map<int,vector<int>> positions;
        for(int i=0;i<(int)nums.size();++i)positions[nums[i]].push_back(i);
        int answer=0;
        for(auto& [value,list]:positions){
            int left=0;
            for(int right=0;right<(int)list.size();++right){
                while(list[right]-list[left]-(right-left)>k)++left;
                answer=max(answer,right-left+1);
            }
        }
        return answer;
    }
};
