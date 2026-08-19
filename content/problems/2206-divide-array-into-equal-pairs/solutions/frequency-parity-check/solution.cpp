class Solution {
    public:bool divideArray(vector<int>& nums){
        unordered_set<int> odd;
        for(int value:nums)if(odd.count(value))odd.erase(value);
        else odd.insert(value);
        return odd.empty();
    }
};
