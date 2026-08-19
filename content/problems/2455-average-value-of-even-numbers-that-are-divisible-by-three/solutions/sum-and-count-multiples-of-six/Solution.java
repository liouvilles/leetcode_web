class Solution {
    public int averageValue(int[] nums){
        int sum=0,count=0;
        for(int value:nums)if(value%6==0){
            sum+=value;
            count++;
        }
        return count==0?0:sum/count;
    }
}
