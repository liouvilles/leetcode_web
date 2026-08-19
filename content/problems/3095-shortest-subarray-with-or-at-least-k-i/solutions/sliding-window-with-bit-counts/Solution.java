class Solution {
    public int minimumSubarrayLength(int[] nums,int k){
        int[] bitCount=new int[31];
        int left=0,currentOr=0,answer=nums.length+1;
        for(int right=0;right<nums.length;right++){
            for(int bit=0;bit<31;bit++)if((nums[right]&(1<<bit))!=0){
                bitCount[bit]++;
                currentOr|=1<<bit;
            }while(left<=right&&currentOr>=k){
                answer=Math.min(answer,right-left+1);
                for(int bit=0;bit<31;bit++)if((nums[left]&(1<<bit))!=0&&--bitCount[bit]==0)currentOr&=~(1<<bit);
                left++;
            }
        }
        return answer==nums.length+1?-1:answer;
    }
}
