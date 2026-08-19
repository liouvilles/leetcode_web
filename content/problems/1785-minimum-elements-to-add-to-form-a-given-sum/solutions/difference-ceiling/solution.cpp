class Solution {
    public: int minElements(vector<int>& nums,int limit,int goal){
        long long sum=accumulate(nums.begin(),nums.end(),0LL),difference=llabs((long long)goal-sum);
        return (difference+limit-1)/limit;
    }
};
