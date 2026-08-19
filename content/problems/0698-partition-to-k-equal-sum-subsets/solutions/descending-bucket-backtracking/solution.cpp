class Solution {
    bool place(vector<int>& nums,int index,vector<int>& buckets,int target){
        if(index<0)return true;
        int value=nums[index],previous=-1;
        for(int bucket=0;bucket<(int)buckets.size();++bucket){
            if(buckets[bucket]==previous||buckets[bucket]+value>target)continue;
            previous=buckets[bucket];
            buckets[bucket]+=value;
            if(place(nums,index-1,buckets,target))return true;
            buckets[bucket]-=value;
            if(buckets[bucket]==0)break;
        }
        return false;
    }
    public:bool canPartitionKSubsets(vector<int>& nums,int k){
        int sum=accumulate(nums.begin(),nums.end(),0);
        if(sum%k)return false;
        int target=sum/k;
        sort(nums.begin(),nums.end());
        if(nums.back()>target)return false;
        vector<int> buckets(k);
        return place(nums,nums.size()-1,buckets,target);
    }
};
