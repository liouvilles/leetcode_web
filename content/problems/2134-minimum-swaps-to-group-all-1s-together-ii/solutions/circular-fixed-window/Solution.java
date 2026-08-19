class Solution {
    public int minSwaps(int[] nums){
        int n=nums.length,ones=Arrays.stream(nums).sum();
        if(ones<=1)return 0;
        int window=0;
        for(int i=0;i<ones;i++)window+=nums[i%n];
        int maximum=window;
        for(int end=ones;end<ones+n;end++){
            window+=nums[end%n]-nums[(end-ones)%n];
            maximum=Math.max(maximum,window);
        }
        return ones-maximum;
    }
}
