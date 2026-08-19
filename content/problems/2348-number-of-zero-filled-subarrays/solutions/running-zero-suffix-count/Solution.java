class Solution {
    public long zeroFilledSubarray(int[] nums){
        long run=0,answer=0;
        for(int value:nums){
            run=value==0?run+1:0;
            answer+=run;
        }
        return answer;
    }
}
