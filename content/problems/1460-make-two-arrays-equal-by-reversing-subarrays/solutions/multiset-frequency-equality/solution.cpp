class Solution {
    public: bool canBeEqual(vector<int>& target,vector<int>& arr){
        unordered_map<int,int> count;
        for(int value:target)++count[value];
        for(int value:arr)--count[value];
        for(auto [value,frequency]:count)if(frequency)return false;
        return true;
    }
};
