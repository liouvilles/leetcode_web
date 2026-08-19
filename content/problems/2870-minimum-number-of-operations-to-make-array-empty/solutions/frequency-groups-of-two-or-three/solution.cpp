class Solution {
    public:int minOperations(vector<int>& nums){
        unordered_map<int,int> frequency;
        for(int value:nums)++frequency[value];
        int operations=0;
        for(auto [value,count]:frequency){
            if(count==1)return -1;
            operations+=(count+2)/3;
        }
        return operations;
    }
};
