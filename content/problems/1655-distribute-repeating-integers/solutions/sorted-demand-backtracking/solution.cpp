class Solution {
    bool assign(int index,vector<int>& quantity,vector<int>& capacity){
        if(index<0)return true;
        int previous=-1;
        for(int& available:capacity)if(available>=quantity[index]&&available!=previous){
            int before=available;
            available-=quantity[index];
            if(assign(index-1,quantity,capacity))return true;
            available=before;
            previous=before;
        }
        return false;
    }
    public:bool canDistribute(vector<int>& nums,vector<int>& quantity){
        unordered_map<int,int> counts;
        for(int value:nums)++counts[value];
        vector<int> capacity;
        for(auto [value,count]:counts)capacity.push_back(count);
        sort(quantity.begin(),quantity.end());
        return assign(quantity.size()-1,quantity,capacity);
    }
};
