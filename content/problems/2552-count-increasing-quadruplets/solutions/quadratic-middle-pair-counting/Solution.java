class Solution {
    public long countQuadruplets(int[] nums){
        int n=nums.length;
        int[] less=new int[n];
        long answer=0;
        for(int j=0;j<n;j++){
            int greater=0;
            for(int k=n-1;k>j;k--){
                if(nums[k]>nums[j])greater++;
                else answer+=(long)less[k]*greater;
            }
            for(int k=j+1;k<n;k++)if(nums[j]<nums[k])less[k]++;
        }
        return answer;
    }
}
