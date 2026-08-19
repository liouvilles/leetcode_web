class Solution {
    public boolean hasAlternatingBits(int n){
        int value=n^(n>>1);
        return (value&(value+1))==0;
    }
}
