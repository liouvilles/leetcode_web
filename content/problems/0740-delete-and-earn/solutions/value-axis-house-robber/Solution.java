class Solution {
    public int deleteAndEarn(int[] nums){
        int maximum=0;
        for(int value:nums)maximum=Math.max(maximum,value);
        int[] points=new int[maximum+1];
        for(int value:nums)points[value]+=value;
        int take=0,skip=0;
        for(int value=0;value<=maximum;value++){
            int newTake=skip+points[value],newSkip=Math.max(skip,take);
            take=newTake;
            skip=newSkip;
        }
        return Math.max(take,skip);
    }
}
