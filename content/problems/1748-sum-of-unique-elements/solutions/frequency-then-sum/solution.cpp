class Solution {
    public: int sumOfUnique(vector<int>& nums){
        unordered_map<int,int> frequency;
        for(int value:nums)++frequency[value];
        int answer=0;
        for(auto [value,count]:frequency)if(count==1)answer+=value;
        return answer;
    }
};
