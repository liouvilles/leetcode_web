class Solution {
    bool match(vector<int>& nums,int position,vector<int>& group){
        for(int i=0;i<(int)group.size();++i)if(nums[position+i]!=group[i])return false;
        return true;
    }
    public:bool canChoose(vector<vector<int>>& groups,vector<int>& nums){
        int position=0;
        for(auto& group:groups){
            while(position+(int)group.size()<=(int)nums.size()&&!match(nums,position,group))++position;
            if(position+(int)group.size()>(int)nums.size())return false;
            position+=group.size();
        }
        return true;
    }
};
