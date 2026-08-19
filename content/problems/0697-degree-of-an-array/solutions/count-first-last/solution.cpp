class Solution {
    public: int findShortestSubArray(vector<int>& nums){
        unordered_map<int,int> first,count;
        int degree=0,length=0;
        for(int i=0;i<(int)nums.size();++i){
            int value=nums[i];
            if(!first.count(value))first[value]=i;
            int frequency=++count[value],span=i-first[value]+1;
            if(frequency>degree){
                degree=frequency;
                length=span;
            }else if(frequency==degree)length=min(length,span);
        }
        return length;
    }
};
