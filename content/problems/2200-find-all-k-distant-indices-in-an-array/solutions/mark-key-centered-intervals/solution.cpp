class Solution {
    public:vector<int> findKDistantIndices(vector<int>& nums,int key,int k){
        vector<bool> nearby(nums.size());
        for(int j=0;j<(int)nums.size();++j)if(nums[j]==key)for(int i=max(0,j-k);i<=min((int)nums.size()-1,j+k);++i)nearby[i]=true;
        vector<int> answer;
        for(int i=0;i<(int)nums.size();++i)if(nearby[i])answer.push_back(i);
        return answer;
    }
};
