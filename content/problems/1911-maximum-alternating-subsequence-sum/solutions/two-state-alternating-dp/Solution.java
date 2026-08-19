class Solution {
    public long maxAlternatingSum(int[] nums){
        long plus=0,minus=0;
        for(int value:nums){
            long oldPlus=plus,oldMinus=minus;
            plus=Math.max(oldPlus,oldMinus+value);
            minus=Math.max(oldMinus,oldPlus-value);
        }
        return plus;
    }
}
