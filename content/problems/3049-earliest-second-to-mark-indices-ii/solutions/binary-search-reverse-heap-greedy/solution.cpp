class Solution {
    bool canFinish(vector<int>& nums,vector<int>& changeIndices,int seconds,long long base){
        vector<int> first(nums.size(),-1);
        for(int time=seconds-1;time>=0;--time)first[changeIndices[time]-1]=time;
        priority_queue<int,vector<int>,greater<int>> chosen;
        int available=0;
        long long saved=0;
        for(int time=seconds-1;time>=0;--time){
            int index=changeIndices[time]-1,value=nums[index];
            if(time==first[index]&&value>1){
                if(available>0){
                    --available;
                    chosen.push(value);
                    saved+=value-1LL;
                }else if(!chosen.empty()&&chosen.top()<value){
                    int removed=chosen.top();
                    chosen.pop();
                    saved-=removed-1LL;
                    ++available;
                    chosen.push(value);
                    saved+=value-1LL;
                }else ++available;
            }else ++available;
        }
        return base-saved<=seconds;
    }
    public:int earliestSecondToMarkIndices(vector<int>& nums,vector<int>& changeIndices){
        long long base=nums.size();
        for(int value:nums)base+=value;
        int left=1,right=changeIndices.size()+1;
        while(left<right){
            int middle=(left+right)/2;
            if(canFinish(nums,changeIndices,middle,base))right=middle;
            else left=middle+1;
        }
        return left==(int)changeIndices.size()+1?-1:left;
    }
};
