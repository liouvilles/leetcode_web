class Solution {
    public int minimumArrayLength(int[] nums){
        int minimum=nums[0];
        for(int value:nums)minimum=Math.min(minimum,value);
        int count=0;
        for(int value:nums){
            if(value%minimum!=0)return 1;
            if(value==minimum)count++;
        }
        return (count+1)/2;
    }
}
