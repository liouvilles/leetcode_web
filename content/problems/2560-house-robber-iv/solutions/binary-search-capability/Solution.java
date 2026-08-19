class Solution {
    private boolean possible(int[] nums,int k,int limit){
        int count=0;
        for(int i=0;i<nums.length;){
            if(nums[i]<=limit){
                count++;
                i+=2;
            }else i++;
        }
        return count>=k;
    }
    public int minCapability(int[] nums,int k){
        int left=Arrays.stream(nums).min().getAsInt(),right=Arrays.stream(nums).max().getAsInt();
        while(left<right){
            int middle=left+(right-left)/2;
            if(possible(nums,k,middle))right=middle;
            else left=middle+1;
        }
        return left;
    }
}
