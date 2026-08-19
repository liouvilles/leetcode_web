class Solution {
    public boolean canPartitionKSubsets(int[] nums,int k){
        int sum=Arrays.stream(nums).sum();
        if(sum%k!=0)return false;
        int target=sum/k;
        Arrays.sort(nums);
        if(nums[nums.length-1]>target)return false;
        int[] buckets=new int[k];
        return place(nums,nums.length-1,buckets,target);
    }
    private boolean place(int[] nums,int index,int[] buckets,int target){
        if(index<0)return true;
        int value=nums[index],previous=-1;
        for(int bucket=0;bucket<buckets.length;bucket++){
            if(buckets[bucket]==previous||buckets[bucket]+value>target)continue;
            previous=buckets[bucket];
            buckets[bucket]+=value;
            if(place(nums,index-1,buckets,target))return true;
            buckets[bucket]-=value;
            if(buckets[bucket]==0)break;
        }
        return false;
    }
}
