class Solution {
    private long priceSum(long number,int x){
        long value=number+1,total=0;
        for(int bit=x-1;bit<60;bit+=x){
            long half=1L<<bit,cycle=half<<1;
            total+=(value/cycle)*half+Math.max(0L,value%cycle-half);
        }
        return total;
    }
    public long findMaximumNumber(long k,int x){
        long low=0,high=(k+1)<<x;
        while(low<high){
            long middle=low+(high-low)/2;
            if(priceSum(middle,x)<=k)low=middle+1;
            else high=middle;
        }
        return low-1;
    }
}
