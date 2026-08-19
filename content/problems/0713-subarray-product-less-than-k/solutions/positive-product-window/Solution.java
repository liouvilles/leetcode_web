class Solution {
    public int numSubarrayProductLessThanK(int[] nums,int k){
        if(k<=1)return 0;
        long product=1;
        int left=0,answer=0;
        for(int right=0;right<nums.length;right++){
            product*=nums[right];
            while(product>=k)product/=nums[left++];
            answer+=right-left+1;
        }
        return answer;
    }
}
