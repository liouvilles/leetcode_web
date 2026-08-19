class Solution {
    private boolean feasible(int[] nums,int p,int limit){
        int pairs=0;
        for(int i=0;i+1<nums.length&&pairs<p;){
            if(nums[i+1]-nums[i]<=limit){
                pairs++;
                i+=2;
            }else i++;
        }
        return pairs>=p;
    }
    public int minimizeMax(int[] nums,int p){
        Arrays.sort(nums);
        int left=0,right=nums[nums.length-1]-nums[0];
        while(left<right){
            int middle=left+(right-left)/2;
            if(feasible(nums,p,middle))right=middle;
            else left=middle+1;
        }
        return left;
    }
}
