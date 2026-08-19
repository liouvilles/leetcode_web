class Solution {
    public int minElements(int[] nums,int limit,int goal){
        long sum=0;
        for(int value:nums)sum+=value;
        long difference=Math.abs((long)goal-sum);
        return (int)((difference+limit-1)/limit);
    }
}
