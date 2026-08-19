class Solution {
    public: vector<int> getAverages(vector<int>& nums,int k){
        vector<int> answer(nums.size(),-1);
        int window=2*k+1;
        if(window>(int)nums.size())return answer;
        long long sum=accumulate(nums.begin(),nums.begin()+window,0LL);
        for(int center=k;center+k<(int)nums.size();++center){
            answer[center]=sum/window;
            if(center+k+1<(int)nums.size())sum+=nums[center+k+1]-nums[center-k];
        }
        return answer;
    }
};
