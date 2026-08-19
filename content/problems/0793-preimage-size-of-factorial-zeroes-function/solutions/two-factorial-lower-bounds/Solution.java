class Solution {
    public int preimageSizeFZF(int k){
        return(int)(lowerBound((long)k+1)-lowerBound(k));
    }
    private long lowerBound(long target){
        long low=0,high=5*(target+1);
        while(low<high){
            long middle=low+(high-low)/2;
            if(zeroes(middle)>=target)high=middle;
            else low=middle+1;
        }
        return low;
    }
    private long zeroes(long value){
        long result=0;
        while(value>0){
            value/=5;
            result+=value;
        }
        return result;
    }
}
