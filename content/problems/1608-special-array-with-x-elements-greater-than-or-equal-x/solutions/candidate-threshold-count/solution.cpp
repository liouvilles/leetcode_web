class Solution { public: int specialArray(vector<int>& nums){for(int x=0;x<=(int)nums.size();++x)if(count_if(nums.begin(),nums.end(),[&](int value){return value>=x;})==x)return x;return -1;} };
