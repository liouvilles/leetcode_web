class Solution {
    private int[] sums(int[] nums,int start,int length){
        int[] sums=new int[1<<length];
        for(int mask=1;mask<sums.length;mask++){
            int bit=Integer.numberOfTrailingZeros(mask);
            sums[mask]=sums[mask^(1<<bit)]+nums[start+bit];
        }
        return sums;
    }
    public int minAbsDifference(int[] nums,int goal){
        int middle=nums.length/2;
        int[] left=sums(nums,0,middle),right=sums(nums,middle,nums.length-middle);
        Arrays.sort(right);
        int answer=Math.abs(goal);
        for(int value:left){
            int target=goal-value,index=Arrays.binarySearch(right,target);
            if(index>=0)return 0;
            index=-index-1;
            if(index<right.length)answer=Math.min(answer,Math.abs(value+right[index]-goal));
            if(index>0)answer=Math.min(answer,Math.abs(value+right[index-1]-goal));
        }
        return answer;
    }
}
