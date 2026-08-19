class Solution {
    private long side(long peak,int length){
        if(peak>=length)return (peak+peak-length+1)*length/2;
        return peak*(peak+1)/2+(length-peak);
    }
    public int maxValue(int n,int index,int maxSum){
        int left=1,right=maxSum;
        while(left<right){
            int middle=left+(right-left+1)/2;
            long required=middle+side(middle-1,index)+side(middle-1,n-index-1);
            if(required<=maxSum)left=middle;
            else right=middle-1;
        }
        return left;
    }
}
