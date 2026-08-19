class Solution {
    public int smallestDistancePair(int[] nums,int k){
        Arrays.sort(nums);
        int left=0,right=nums[nums.length-1]-nums[0];
        while(left<right){
            int middle=left+(right-left)/2;
            long count=0;
            for(int l=0,r=0;r<nums.length;r++){
                while(nums[r]-nums[l]>middle)l++;
                count+=r-l;
            }
            if(count>=k)right=middle;
            else left=middle+1;
        }
        return left;
    }
}
