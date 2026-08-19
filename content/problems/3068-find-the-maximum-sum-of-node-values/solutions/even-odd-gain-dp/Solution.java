class Solution {
    public long maximumValueSum(int[] nums,int k,int[][] edges){
        long sum=0,even=0,odd=Long.MIN_VALUE/4;
        for(int value:nums){
            sum+=value;
            long gain=(long)(value^k)-value;
            long nextEven=Math.max(even,odd+gain);
            long nextOdd=Math.max(odd,even+gain);
            even=nextEven;
            odd=nextOdd;
        }
        return sum+even;
    }
}
