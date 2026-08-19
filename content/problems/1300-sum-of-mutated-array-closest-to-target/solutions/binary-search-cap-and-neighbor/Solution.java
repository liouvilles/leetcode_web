class Solution {
    public int findBestValue(int[] arr,int target){
        int left=0,right=0;
        for(int value:arr)right=Math.max(right,value);
        while(left<right){
            int middle=(left+right)/2;
            if(sum(arr,middle)>=target)right=middle;
            else left=middle+1;
        }
        int lower=Math.max(0,left-1);
        return Math.abs(sum(arr,lower)-target)<=Math.abs(sum(arr,left)-target)?lower:left;
    }
    private long sum(int[] arr,int cap){
        long total=0;
        for(int value:arr)total+=Math.min(value,cap);
        return total;
    }
}
