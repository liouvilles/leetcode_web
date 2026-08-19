class Solution {
    public int maximumCount(int[] nums){
        int negative=0,positive=0;
        for(int value:nums){
            if(value<0)negative++;
            else if(value>0)positive++;
        }
        return Math.max(negative,positive);
    }
}
