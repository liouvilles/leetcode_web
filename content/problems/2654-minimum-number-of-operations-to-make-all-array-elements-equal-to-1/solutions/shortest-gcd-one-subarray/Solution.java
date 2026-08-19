class Solution {
    private int gcd(int a,int b){
        while(b!=0){
            int next=a%b;
            a=b;
            b=next;
        }
        return a;
    }
    public int minOperations(int[] nums){
        int ones=0;
        for(int value:nums)if(value==1)ones++;
        if(ones>0)return nums.length-ones;
        int best=Integer.MAX_VALUE;
        for(int left=0;left<nums.length;left++){
            int value=0;
            for(int right=left;right<nums.length;right++){
                value=gcd(value,nums[right]);
                if(value==1){
                    best=Math.min(best,right-left+1);
                    break;
                }
            }
        }
        return best==Integer.MAX_VALUE?-1:best+nums.length-2;
    }
}
