class Solution {
    public int countNumbersWithUniqueDigits(int n){
        if(n==0)return 1;
        int total=10,unique=9,available=9;
        for(int digits=2;digits<=n;digits++){
            unique*=available--;
            total+=unique;
        }
        return total;
    }
}
