class Solution {
    public int maximumTop(int[] nums,int k){
        if(k==0)return nums[0];
        if(nums.length==1)return k%2==0?nums[0]:-1;
        int answer=-1;
        for(int i=0;i<Math.min(nums.length,k-1);i++)answer=Math.max(answer,nums[i]);
        if(k<nums.length)answer=Math.max(answer,nums[k]);
        return answer;
    }
}
