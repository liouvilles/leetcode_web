class Solution {
    public: vector<int> maxSumOfThreeSubarrays(vector<int>& nums,int k){
        int count=nums.size()-k+1;
        vector<int> sums(count),left(count),right(count);
        int window=0;
        for(int i=0;i<(int)nums.size();++i){
            window+=nums[i];
            if(i>=k)window-=nums[i-k];
            if(i>=k-1)sums[i-k+1]=window;
        }
        int best=0;
        for(int i=0;i<count;++i){
            if(sums[i]>sums[best])best=i;
            left[i]=best;
        }
        best=count-1;
        for(int i=count-1;i>=0;--i){
            if(sums[i]>=sums[best])best=i;
            right[i]=best;
        }
        vector<int> answer(3);
        int maximum=-1;
        for(int middle=k;middle<=count-k-1;++middle){
            int first=left[middle-k],third=right[middle+k],total=sums[first]+sums[middle]+sums[third];
            if(total>maximum){
                maximum=total;
                answer={
                    first,middle,third
                };
            }
        }
        return answer;
    }
};
