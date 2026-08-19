class Solution {
    public int arrangeCoins(int n){
        long left=0,right=n;
        while(left<right){
            long middle=left+(right-left+1)/2;
            if(middle*(middle+1)/2<=n)left=middle;
            else right=middle-1;
        }
        return(int)left;
    }
}
