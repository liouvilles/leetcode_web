class Solution {
    public:int findFinalValue(vector<int>& nums,int original){
        unordered_set<int> values(nums.begin(),nums.end());
        while(values.count(original))original*=2;
        return original;
    }
};
