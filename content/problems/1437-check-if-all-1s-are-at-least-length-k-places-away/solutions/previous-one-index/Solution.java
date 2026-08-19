class Solution {
    public boolean kLengthApart(int[] nums,int k){
        int previous=-k-1;
        boolean found=false;
        for(int i=0;i<nums.length;i++)if(nums[i]==1){
            if(found&&i-previous<=k)return false;
            previous=i;
            found=true;
        }
        return true;
    }
}
