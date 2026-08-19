class Solution {
    public int countPrimes(int n){
        boolean[] composite=new boolean[n];
        for(int p=2;(long)p*p<n;p++)if(!composite[p])for(int value=p*p;value<n;value+=p)composite[value]=true;
        int count=0;
        for(int value=2;value<n;value++)if(!composite[value])count++;
        return count;
    }
}
