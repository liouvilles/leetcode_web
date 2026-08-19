class Solution {
    public: int countTriplets(vector<int>& nums){
        unordered_map<int,int> frequency;
        for(int a:nums)for(int b:nums)++frequency[a&b];
        int answer=0;
        for(int value:nums)for(auto [mask,count]:frequency)if((mask&value)==0)answer+=count;
        return answer;
    }
};
