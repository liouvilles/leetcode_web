class Solution {
    public int minOperations(int[] nums){
        int increments=0,maximum=0;
        for(int value:nums){
            increments+=Integer.bitCount(value);
            maximum=Math.max(maximum,value);
        }
        int doublings=0;
        while(maximum>1){
            maximum>>=1;
            doublings++;
        }
        return increments+doublings;
    }
}
