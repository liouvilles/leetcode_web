class Solution {
    public int sumOfPower(int[] nums){
        final long MOD=1_000_000_007;
        Arrays.sort(nums);
        long answer=0,prefix=0;
        for(int number:nums){
            long value=number,square=value*value%MOD;
            answer=(answer+square*((value+prefix)%MOD))%MOD;
            prefix=(2*prefix+value)%MOD;
        }
        return (int)answer;
    }
}
