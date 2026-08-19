class Solution {
    private long cost(int[] nums,long[] prefix,int left,int right){
        int middle=(left+right)>>>1;
        long leftCost=(long)nums[middle]*(middle-left)-(prefix[middle]-prefix[left]);
        long rightCost=prefix[right+1]-prefix[middle+1]-(long)nums[middle]*(right-middle);
        return leftCost+rightCost;
    }
    public int maxFrequencyScore(int[] nums,long k){
        Arrays.sort(nums);
        long[] prefix=new long[nums.length+1];
        for(int i=0;i<nums.length;i++)prefix[i+1]=prefix[i]+nums[i];
        int left=0,answer=1;
        for(int right=0;right<nums.length;right++){
            while(cost(nums,prefix,left,right)>k)left++;
            answer=Math.max(answer,right-left+1);
        }
        return answer;
    }
}
