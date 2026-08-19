class Solution {
    public: int arrayNesting(vector<int>& nums){
        vector<bool> visited(nums.size());
        int best=0;
        for(int start=0;start<(int)nums.size();++start)if(!visited[start]){
            int length=0,current=start;
            while(!visited[current]){
                visited[current]=true;
                current=nums[current];
                ++length;
            }
            best=max(best,length);
        }
        return best;
    }
};
