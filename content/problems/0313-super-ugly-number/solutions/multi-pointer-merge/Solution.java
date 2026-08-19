class Solution {
    public int nthSuperUglyNumber(int n,int[] primes){
        int[] ugly=new int[n],pointers=new int[primes.length];
        ugly[0]=1;
        for(int index=1;index<n;index++){
            long next=Long.MAX_VALUE;
            for(int i=0;i<primes.length;i++)next=Math.min(next,(long)ugly[pointers[i]]*primes[i]);
            ugly[index]=(int)next;
            for(int i=0;i<primes.length;i++)if((long)ugly[pointers[i]]*primes[i]==next)pointers[i]++;
        }
        return ugly[n-1];
    }
}
