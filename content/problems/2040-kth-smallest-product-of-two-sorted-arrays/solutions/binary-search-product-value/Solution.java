class Solution {
    private int lower(int[] values,long target){
        int left=0,right=values.length;
        while(left<right){
            int middle=(left+right)/2;
            if(values[middle]<target)left=middle+1;
            else right=middle;
        }
        return left;
    }
    private int upper(int[] values,long target){
        int left=0,right=values.length;
        while(left<right){
            int middle=(left+right)/2;
            if(values[middle]<=target)left=middle+1;
            else right=middle;
        }
        return left;
    }
    private long count(int[] first,int[] second,long limit){
        long result=0;
        for(int value:first)if(value>0)result+=upper(second,Math.floorDiv(limit,value));
        else if(value<0){
            long ceiling=-Math.floorDiv(-limit,value);
            result+=second.length-lower(second,ceiling);
        }else if(limit>=0)result+=second.length;
        return result;
    }
    public long kthSmallestProduct(int[] nums1,int[] nums2,long k){
        long left=-10_000_000_000L,right=10_000_000_000L;
        while(left<right){
            long middle=left+(right-left)/2;
            if(count(nums1,nums2,middle)>=k)right=middle;
            else left=middle+1;
        }
        return left;
    }
}
