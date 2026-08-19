class Solution {
    private long gcd(long a,long b){
        while(b!=0){
            long remainder=a%b;
            a=b;
            b=remainder;
        }
        return a;
    }
    public int subarrayLCM(int[] nums,int k){
        int answer=0;
        for(int left=0;left<nums.length;left++){
            long lcm=1;
            for(int right=left;right<nums.length;right++){
                lcm=lcm/gcd(lcm,nums[right])*nums[right];
                if(lcm>k||k%lcm!=0)break;
                if(lcm==k)answer++;
            }
        }
        return answer;
    }
}
