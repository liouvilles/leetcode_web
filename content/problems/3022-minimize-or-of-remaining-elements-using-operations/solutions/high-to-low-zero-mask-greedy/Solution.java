class Solution {
    public int minOrAfterOperations(int[] nums,int k){
        int n=nums.length,zeroMask=0,answer=0;
        for(int bit=29;bit>=0;bit--){
            int bitValue=1<<bit,candidate=zeroMask|bitValue,groups=0,current=candidate;
            for(int value:nums){
                current&=value;
                if(current==0){
                    groups++;
                    current=candidate;
                }
            }
            if(n-groups<=k)zeroMask=candidate;
            else answer|=bitValue;
        }
        return answer;
    }
}
