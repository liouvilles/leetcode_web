class Solution {
    public: int arrangeCoins(int n){
        long long left=0,right=n;
        while(left<right){
            long long middle=left+(right-left+1)/2;
            if(middle*(middle+1)/2<=n)left=middle;
            else right=middle-1;
        }
        return left;
    }
};
