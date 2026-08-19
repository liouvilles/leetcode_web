class Solution {
    public int differenceOfSum(int[] nums){
        int elementSum=0,digitSum=0;
        for(int value:nums){
            elementSum+=value;
            for(int copy=value;copy>0;copy/=10)digitSum+=copy%10;
        }
        return Math.abs(elementSum-digitSum);
    }
}
