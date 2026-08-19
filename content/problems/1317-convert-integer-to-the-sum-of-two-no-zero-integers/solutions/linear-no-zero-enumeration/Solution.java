class Solution {
    public int[] getNoZeroIntegers(int n){
        for(int a=1;a<n;a++)if(noZero(a)&&noZero(n-a))return new int[]{
            a,n-a
        };
        return new int[0];
    }
    private boolean noZero(int value){
        while(value>0){
            if(value%10==0)return false;
            value/=10;
        }
        return true;
    }
}
