class Solution {
    public:int countSubarrays(vector<int>& nums,int k){
        int pivot=find(nums.begin(),nums.end(),k)-nums.begin();
        unordered_map<int,int> frequency;
        frequency[0]=1;
        int balance=0;
        for(int i=pivot-1;i>=0;--i){
            balance+=nums[i]>k?1:-1;
            ++frequency[balance];
        }
        long long answer=0;
        balance=0;
        for(int i=pivot;i<(int)nums.size();++i){
            if(i>pivot)balance+=nums[i]>k?1:-1;
            answer+=frequency[-balance]+frequency[1-balance];
        }
        return answer;
    }
};
